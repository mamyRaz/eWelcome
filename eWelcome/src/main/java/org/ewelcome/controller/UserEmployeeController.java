/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.controller;

import javax.validation.Valid;
import org.ewelcome.entity.UserEmployee;
import org.ewelcome.service.UserEmployeeService;
import org.ewelcome.service.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author angele
 */

@Controller
@RequestMapping("/employee")
public class UserEmployeeController {
    private final Logger LOGGER = LoggerFactory.getLogger(MeetingController.class);
    
    @Autowired 
    private UserEmployeeService userEmployeeService;
    
    
    @Autowired 
    private UserRoleService userRoleService;
    
    @GetMapping("/list")
    public String list( Model model) {            
        LOGGER.info("AFFICHEGE PLANNING SECRETAIRE"+userEmployeeService.findAll());
        model.addAttribute("users", userEmployeeService.findAll());    
        return "admin/listeUser";
    }
    
    @GetMapping("/add")
    public String add( Model model) {             
        LOGGER.info("FORM AJOUT"); 
        UserEmployee ue =  new UserEmployee();
        model.addAttribute("role", userRoleService.findAll()); 
        model.addAttribute("ue", ue);             
        LOGGER.info("FORM AJOUT");    
        return "admin/ajoutUser";
    }
    
    @PostMapping("/add")
    public String adding( @Valid UserEmployee ue , Model model) {   
        LOGGER.info("AJOUT DEB"); 
        userEmployeeService.save(ue);
        LOGGER.info("AJOUT FIN");  
        return "redirect:/employee/list";
    }
}
