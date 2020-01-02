/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.controller;


import javax.validation.Valid;
import org.ewelcome.entity.Meeting;
import org.ewelcome.entity.Person;
import org.ewelcome.entity.TypeMeeting;
import org.ewelcome.service.MeetingService;
import org.ewelcome.service.MeetingStateService;
import org.ewelcome.service.PersonService;
import org.ewelcome.service.TypeMeetingService;
import org.ewelcome.service.UserEmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * Class pour gérer les rdv et la communication entre les entités et la vue
 */
@Controller
@RequestMapping("/meeting")
public class MeetingController {
    
    private final Logger LOGGER = LoggerFactory.getLogger(MeetingController.class);
    //Pour pouvoir faire l'injection du code sur l'entité Meeting 
    @Autowired 
    private MeetingService meetingService;
    
     //Pour pouvoir envoyer la liste de types de rdv dans certaines la vue nouveau rdv
    @Autowired 
    private TypeMeetingService typeMeetingService;
    //Pour pouvoir envoyer la liste de visiteur enregistrés dans certaines vues
    @Autowired 
    private UserEmployeeService userEmployeeService;
    //Pour mettre a jour la liste de rdv d'une personne
    @Autowired 
    private PersonService personService;
    //Pour mettre a jour l'etat d'un rdv
    @Autowired 
    private MeetingStateService meetingStateService;
    
    /*La méthode findAll envoie tous les rdv à la vue liste de meetings à travers du mode.
         Le paramètre Model model permet d'envoyer des données au template aux vues.
    */
    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("meetings", meetingService.findAllOrderByDate());
        
        return "meeting/listMeeting";
    }
    
    /*La méthode formBookMeeting demande le formulaire de création d'un nouveau rdv. Ce formulaire présente des champs à 
    remplir par une personne avec ou sans accès à l'application. Sa validation provoque le lancement d'une requête
    HTTP/POST
    */
    @GetMapping("/book")
    public String formBookMeeting(Model model, @ModelAttribute("person") Person person) {
        Meeting meeting = new Meeting();
        model.addAttribute("typesMeeting", typeMeetingService.findAll());
        model.addAttribute("employees", userEmployeeService.findAll());
        model.addAttribute("person", person);
        model.addAttribute("meeting", meeting);
        return "meeting/formBookMeeting";
    }
    
    /*
     La méthode bookedMeeting enregistre le rdv saisi dans le formulaire (si ses contraintes sont respectées) 
     Ce comportement est exécuté dans le cas d'une requête HTTP/POST sur /meeting/book (engendrée par le formulaire)
    */
    /*
      L'entitée Meeting (@Entity) possède des champs name qui doivent éventuellement respecter des contraintes. 
      L'annotation @Valid demande à Hibernate Validator de vérifier le respect de ces contraintes
    */
    @PostMapping("/book")
    public String bookedMeeting(@Valid Meeting meeting, BindingResult br, Model model, @ModelAttribute("person") Person person) {
        //Le paramètre BindingResult permet de vérifier les éventuels erreurs.
        if (br.hasErrors()) {
            
            return "person/signIn";
        }
        meetingService.save(meeting);
        meeting.setMeetingState(meetingStateService.findByState("En attente"));
        /*On récupere depuis le model la person qui demande le rdv et par la suite on savegarde les objets modifiés 
        meeting et person pour pouvir enregistrer les données de la table MatchPersonMeeting
        */
        person.getMeetingList().add(meeting);
        model.addAttribute("person", person);
        meeting.getGuestList().add(person);
       
        personService.save(person);
        meetingService.save(meeting);
        
        return "meeting/meetingRequiredSent";
    }
    
     /*La méthode cancelMeeting modifie l'état d'un rdv à annulé dans la bd et met a jour la vue de 
       l'etat de la demande d'un visiteur
    */
    
    @GetMapping("/cancel")
    public String cancelMeeting(@RequestParam(name = "id") Long id, Model model) {
        Meeting meetingToModify =  meetingService.findByIdMeeting(id);
        if(meetingToModify!=null){
            meetingToModify.setMeetingState(meetingStateService.findByState("Annulé"));
            meetingService.save(meetingToModify);
            String message = "C'est à notre grand regret que on vous informe par la présente qu'on ne peut malheureusement pas confirmer le rendez-vous du "+meetingToModify.getDateMeeting() + ", à (heures)";
            model.addAttribute("message", message);
            return "meeting/reponseMeetingRequest";
        }
        return "redirect:/meeting";
    }
    
    /*La méthode acceptMeeting modifie l'état d'un rdv à "confirmé" dans la bd et met a jour la vue de 
       l'etat de la demande d'un visiteur
    */
    @GetMapping("/accept")
    public String acceptMeeting(@RequestParam(name = "id") Long id, Model model) {
        Meeting meetingToModify =  meetingService.findByIdMeeting(id);
        if(meetingToModify!=null){
            meetingToModify.setMeetingState(meetingStateService.findByState("Confirmé"));
            meetingService.save(meetingToModify);
            String message = "Suite à votre demande, on vous confirme le rendez-vous du "+meetingToModify.getDateMeeting()+", à "+ meetingToModify.getHour()+ " heure(s)";
            model.addAttribute("message", message);
            return "meeting/reponseMeetingRequest";
        }
        return "redirect:/meeting";
    }
   

}
