/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.controller;

import java.util.Optional;
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
 * @author refin
 */
@Controller
@RequestMapping("/meeting")
public class MeetingController {

    private final Logger LOGGER = LoggerFactory.getLogger(MeetingController.class);
    
    @Autowired 
    private MeetingService meetingService;
    
    @Autowired 
    private TypeMeetingService typeMeetingService;
    
    @Autowired 
    private UserEmployeeService userEmployeeService;
    
    @Autowired 
    private PersonService personService;
    
    @Autowired 
    private MeetingStateService meetingStateService;
    
    private TypeMeeting meeting = new TypeMeeting("Réunion");
    private TypeMeeting interview = new TypeMeeting("Entretien");
    private TypeMeeting service = new TypeMeeting("Service");
    
   
    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("meetings", meetingService.findAllOrderByDate());
        
        return "meeting/listMeeting";
    }
    
    @GetMapping("/book")
    public String formBookMeeting(Model model, @ModelAttribute("person") Person person) {
        Meeting meeting = new Meeting();
        model.addAttribute("typesMeeting", typeMeetingService.findAll());
        model.addAttribute("employees", userEmployeeService.findAll());
        model.addAttribute("person", person);
        model.addAttribute("meeting", meeting);
        return "meeting/formBookMeeting";
    }
    
    @PostMapping("/book")
    public String bookedMeeting(@Valid Meeting meeting, BindingResult br, Model model, @ModelAttribute("person") Person person) {
        //save person once meetig is confirmed
        if (br.hasErrors()) {
            //Visiteur doit être éffacé de la bd
            personService.delete(person.getId());
            return "person/signIn";
        }
        meetingService.save(meeting);
        meeting.setMeetingState(meetingStateService.findByState("En attente"));
        //On savegarde les objets meeting et person pour pouvir faire la relation many to many
        person.getMeetingList().add(meeting);
        model.addAttribute("person", person);
        meeting.getGuestList().add(person);
        //On sauvegarde encore une fois pour que les données soient liées et sauvegardées dans la table MatchPersonMeeting
        personService.save(person);
        meetingService.save(meeting);
        
        return "meeting/meetingRequiredSent";
    }
    
    @GetMapping("/cancel")
    public String cancelMeeting(@RequestParam(name = "id") Long id, Model model) {
        Meeting meetingToModify =  meetingService.findByIdMeeting(id);
        if(meetingToModify!=null){
            meetingToModify.setMeetingState(meetingStateService.findByState("Annulé"));
            meetingService.save(meetingToModify);
            return "redirect:/meeting";
        }
        return "redirect:/meeting";
    }
    
    @GetMapping("/accept")
    public String acceptMeeting(@RequestParam(name = "id") Long id, Model model) {
        Meeting meetingToModify =  meetingService.findByIdMeeting(id);
        if(meetingToModify!=null){
            meetingToModify.setMeetingState(meetingStateService.findByState("Confirmé"));
            meetingService.save(meetingToModify);
            return "redirect:/meeting";
        }
        return "redirect:/meeting";
    }
   

}
