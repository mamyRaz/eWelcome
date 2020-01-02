/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.controller;

import org.ewelcome.entity.UserVisitor;
import org.ewelcome.service.UserVisitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * Classe pour gérer les visiteurs ayant été enregistrés ainsi que la communication entre les entités et la vue
 */
@Controller
@RequestMapping("/visitor")
public class UserVisitorController {
    private final Logger LOGGER = LoggerFactory.getLogger(MeetingController.class);
    //Pour pouvoir faire l'injection du code sur l'entité UserVisitor (visiteurs enregistrés dans l'application) 
    @Autowired
    private UserVisitorService userVisitorService;
    //Methode qui permet de récuperer la page d'accueil d'un visiteur enregistré. 
    @RequestMapping(method = RequestMethod.GET)
    public String getHomePage(@RequestParam(name = "idVisitor") Long id, Model model) {
        if(id==null){
            return "connectionRequired";
        }
        UserVisitor visitor = userVisitorService.findByIdVisitor(id);
        if(visitor==null){
            return "connectionRequired";
        }
        model.addAttribute("visitor", visitor);
        return "visitor/visitorHomePage";
    }
    
}
