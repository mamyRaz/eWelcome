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
 * @author refin
 */
@Controller
@RequestMapping("/person")
public class PersonController {
    
    private final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);
    
    @Autowired
    private PersonService personService;
    
    @Autowired
    private UserRoleService userRoleService;
    
    private UserRole visitorRole = new UserRole("Visitor");
    

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("meetings", personService.findAll());
        return "meeting/listMeeting";
    }
    
    @GetMapping("/signIn")
    public String formSignIn(Model model) {

        Person person = new Person();
        model.addAttribute("person", person);
        return "person/signUpVisitor";
    }

    @PostMapping("/signIn")
    public String formFilled(@Valid Person person, BindingResult br, Model model,  RedirectAttributes redirectAttributes) {
        /*if (br.hasErrors()) {
            LOGGER.info("Error a la creation de l'objet Person"+ person.toString() + br.getAllErrors().toString());
            return "person/signUpVisitor";
        }*/
        if(userRoleService.findByRole("Visitor")==null){
            userRoleService.save(visitorRole);
        }
        personService.save(person);
        person.setRole(visitorRole);
        redirectAttributes.addAttribute("person", person);
        
        return "redirect:/meeting/book";
    }
}
