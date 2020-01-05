package org.ewelcome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class URLMapping {
        //PAGE ACCEUIL
	@GetMapping("/")
	public String home() {
		return "index";
	}
        
        //PAGE DE CONNEXION
	@GetMapping("/connexion")
	public String connexion() {
		return "connexion";
	}
	
        //LISTE USER POUR L'ADMIN
	@GetMapping("/listeUser")
	public String listeUser() {
		return "admin/listeUser";
	}
	
        //AJOUT USER POUR L'ADMIN
	@GetMapping("/ajoutUser")
	public String ajoutUser() {
		return "admin/ajoutUser";
	}
        
        //DIRIGER LA PAGE VERS LE PLANNING D'UN AGENT
	@GetMapping("/planningAgent")
	public String planningAgent() {
		return "agent/planningAgent";
	}
	
        //DIRIGER LA PAGE VERS L'ACCES A L'APPLICATION SUR PLACE
	@PostMapping("/accesApplicationSurPlace")
	public String accesApplicationSurPlace() {
		return "visiteur/accesApplicationSurPlace";
	}
	
	
	@GetMapping("/impressionBadgeMDPWifi")
	public String impressionBadgeMDPWifi() {
		return "visiteur/impressionBadgeMDPWifi";
	}
        
	//DIRIGER LA PAGE VERS LE PLANNING PRISE DE RDV
	@GetMapping("/planningPriseRDV")
	public String planningPriseRDV() {
		return "visiteur/planningPriseRDV";
	}
	
}
