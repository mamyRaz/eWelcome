/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.controller;

import javax.validation.Valid;
import org.ewelcome.entity.Badge;
import org.ewelcome.entity.Person;
import org.ewelcome.service.BadgeService;
import org.ewelcome.service.MeetingService;
import org.ewelcome.service.PersonService;
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
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author angele
 */
@Controller
@RequestMapping("/badge")
public class BadgeController {
    
    
    @Autowired 
    private BadgeService badgeService;
    
    private final Logger LOGGER = LoggerFactory.getLogger(MeetingController.class);
//    @Autowired 
//    private BadgeService badgeService;
    
    @Autowired 
    private PersonService personService;
    
    /*
    @GetMapping("/afficheVisiteur")
    public String afficheVisiteur() {
	return "/badge/afficheVisiteur";
    }*/
    
    @GetMapping("/afficheVisiteur")
	public String afficheVisiteur(@RequestParam(name = "id") Long id, Model model) {
            //Long i = Long.valueOf("2");
//            if (br.hasErrors()) {
//                return "badge/afficheVisiteur";
//            }
            //RECUPERER LA PERSONNE 
            Person proprioBadge = personService.findById(id).get();
            LOGGER.info("BADGE : "+proprioBadge.getFirstName() +" "+proprioBadge.getLastName());            
            //CREER LE BADGE           
            Badge badge = new Badge();
            //INITIALISER LE BADGE
            badge.setPerson(proprioBadge);            
            //INITIALISER LE BADGE
            badgeService.save(badge);
            LOGGER.info("SAUVEGARDE BADGE : "+badge.getId());
            //AJOUTER LE BADGE AU MODEL
            model.addAttribute("badge",badge);
            return "badge/afficheVisiteur";
	}
        
        
    @PostMapping("/afficheVisiteur")
    public String createBadge(/*, BindingResult br*/) {        
        LOGGER.info("BADGE DEJA CREEER");
        return "/visiteur/impressionBadgeMDPWifi";//
    }
}
