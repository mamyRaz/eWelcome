/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.controller;

import javax.validation.Valid;
import org.ewelcome.entity.Person;
import org.ewelcome.entity.UserRole;
import org.ewelcome.service.PersonService;
import org.ewelcome.service.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * Classe pour gérer les nouveaux visiteurs ou employés ainsi que la communication entre les entités et la vue
 */
@Controller
@RequestMapping("/person")
public class PersonController {
    
    private final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);
    //Pour pouvoir faire l'injection du code sur l'entité Person (visiteurs enregistrés dans l'application)
    @Autowired
    private PersonService personService;
    //Pour pouvoir mettre a jour le role d'une personne. Une fois il est enregistré la personne devient visiteur ou employé
    @Autowired
    private UserRoleService userRoleService;
    
    private UserRole visitorRole = new UserRole("Visiteur");
    
    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("meetings", personService.findAll());
        return "meeting/listMeeting";
    }
    /*La méthode formSignIn demande le formulaire de création d'une nouvelle personne. Sa validation provoque le 
    lancement d'une requête  HTTP/POST
    */
    @GetMapping("/signIn")
    public String formSignIn(Model model) {

        Person person = new Person();
        model.addAttribute("person", person);
        return "person/signUpVisitor";
    }
    /*
     La méthode formFilled enregistre une personne dans la bd. 
     Ce comportement est exécuté dans le cas d'une requête HTTP/POST sur /meeting/book (engendrée par le formulaire)
    */
    /*
      L'entitée Meeting (@Entity) possède des champs name qui doivent éventuellement respecter des contraintes pour 
    la creation de une personne. L'annotation @Valid demande à Hibernate Validator de vérifier le respect de ces contraintes.
    */
    @PostMapping("/signIn")
    public String formFilled(@Valid Person person, BindingResult br, Model model,  RedirectAttributes redirectAttributes) {
        /*if (br.hasErrors()) {
            LOGGER.info("Error a la creation de l'objet Person"+ person.toString() + br.getAllErrors().toString());
            return "person/signUpVisitor";
        }*/
        if(userRoleService.findByRole("Visiteur")==null){
            userRoleService.save(visitorRole);
        }
        personService.save(person);
        person.setRole(visitorRole);
        redirectAttributes.addAttribute("person", person);
        
        return "redirect:/meeting/book";
    }
}
