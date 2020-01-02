/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.controller;

import java.util.Random;
import javax.validation.Valid;
import org.ewelcome.entity.UserVisitor;
import org.ewelcome.entity.WifiCode;
import org.ewelcome.service.UserVisitorService;
import org.ewelcome.service.WifiCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * Class pour gérer les demandes de visiteurs enregistrés pour accéder au réseau wifi ainsi que la communication entre les entités et la vue
 */
@Controller
@RequestMapping("/wifi")
public class WifiCodeController {

    private final Logger LOGGER = LoggerFactory.getLogger(WifiCodeController.class);
    //Pour pouvoir faire l'injection du code sur l'entité WifiCode 
    @Autowired
    private WifiCodeService wifiCodeService;
    //Pour pouvoir récupérer les visiteurs ayant ayant à l'application 
    @Autowired
    private UserVisitorService userVisitorService;
    
    /*La méthode findAll envoie la liste de demandés d'accès à la connexion wifi à la vue 
      cette liste doit étre visible que pour les employés
         Le paramètre Model model permet d'envoyer des données au template aux vues.
    */
    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        /*if (id == null) {
            return "connexion";
        }
        UserVisitor visitor = userVisitorService.findByIdVisitor(id);
        if (visitor == null) {
            return "connectionRequired";
        }
        UserEmployee employee = userEmployeeService.findByIdEmployee(id);
        if (employee == null) {
            return "accessExclusiveEmployees";
        }*/
        model.addAttribute("wifiList", wifiCodeService.findAllActiveRequest());
        return "employee/listWifiRequest";
    }
    
    /*La méthode requestWifi demande le formulaire pour demander l'accès à la connexion wifi. 
    Ce formulaire présente des champs à remplir par un visiteur avec accès à l'application. 
    Sa validation provoque le lancement d'une requête HTTP/POST
    */
    @GetMapping("/request")
    public String requestWifi(@RequestParam(name = "idVisitor") Long id, Model model) {
        if (id == null) {
            return "connectionRequired";
        }
        UserVisitor visitor = userVisitorService.findByIdVisitor(id);
        if (visitor == null) {
            return "connectionRequired";
        }
        WifiCode wifiCode = new WifiCode();
        model.addAttribute("visitor", visitor);
        model.addAttribute("wifiCode", wifiCode);
        return "visitor/wifiCodeFormRequest";
    }
    
    /*
     La méthode requestedWifi enregistre la demande d'accès à la connexion wifi saisi dans le formulaire 
    (si ses contraintes sont respectées).  Ce comportement est exécuté dans le cas d'une requête HTTP/POST 
    sur /wifi/wifi (engendrée par le formulaire)
    */
    @PostMapping("/request")
    public String requestedWifi(@Valid WifiCode wifiCode, BindingResult br, Model model, @ModelAttribute("visitor") UserVisitor visitor) {
        if (br.hasErrors()) {
            return "redirect:/wifi/request(idVisitor=${visitor.idVisitor})";
        }
        wifiCodeService.save(wifiCode);
        wifiCode.setState("En attente");
        wifiCode.setVisitorAuthorized(visitor);
        wifiCodeService.save(wifiCode);
        return "visitor/wifiRequestSent";
    }
    
    /*La méthode cancelWifi modifie l'état d'une demande d'accès d'internet à "refusée" dans la bd 
    et met a jour la vue de la demande d'un visiteur
    */
    @GetMapping("/reject")
    public String cancelWifi(@RequestParam(name = "idWifi") Long id, Model model) {
        WifiCode requestToModifyState = wifiCodeService.findByIdWifiCode(id);
        if (requestToModifyState != null) {
            requestToModifyState.setState("Refusée");
            wifiCodeService.save(requestToModifyState);
            String message = "Suite à votre demande on vous informe par la présente qu'on ne peut malheureusement pas vous donner l'accès à notre réseau wifi par des raisons de sécurité.";
            model.addAttribute("message", message);
            return "visitor/reponseWifiRequest";
        }
        return "redirect:/wifi";
    }

  /*La méthode acceptWifi modifie l'état d'une demande d'accès d'internet à "Acceptée" dans la bd et génére
    le mot de pass pour accéder à la connexion. Finalment elle met à jour la vue de la demande d'un visiteur
    */
    @GetMapping("/accept")
    public String acceptWifi(@RequestParam(name = "idWifi") Long id, Model model) {
        WifiCode requestToGenerateCode = wifiCodeService.findByIdWifiCode(id);
        if (requestToGenerateCode != null) {
            String capitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String smallChars = "abcdefghijklmnopqrstuvwxyz";
            String numbers = "0123456789";
            String symbols = "!@#$%^&*_=+-/.?<>)";
            String values = capitalChars + smallChars + numbers + symbols;
            Random rnd = new Random();
            int len = 10;
            char[] password = new char[len];

            for (int i = 0; i < len; i++) {
                 password[i] = values.charAt(rnd.nextInt(values.length())); 
            }
            requestToGenerateCode.setCode(String.valueOf(password));
            requestToGenerateCode.setState("Acceptée");
            wifiCodeService.save(requestToGenerateCode);
            String message = "Suite à votre demande, on vous confirme que vous pouvez vous connecter à notre réseau wifi avec l'dentifiant: " + requestToGenerateCode.getVisitorAuthorized().getPerson().getEmail() + " et le mot de passe: "+ requestToGenerateCode.getCode() + " à partir du "+ requestToGenerateCode.getInitialDate() + ".";
            model.addAttribute("message", message);
            return "visitor/reponseWifiRequest";
        }
        return "redirect:/wifi";
    }

}
