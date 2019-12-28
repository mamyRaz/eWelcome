package org.ewelcome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class URLMapping {

	@GetMapping("/")
	public String home() {
		return "index";
	}
	@GetMapping("/connexion")
	public String connexion() {
		return "connexion";
	}
	
	@GetMapping("/listeUser")
	public String listeUser() {
		return "admin/listeUser";
	}
	
	@GetMapping("/ajoutUser")
	public String ajoutUser() {
		return "admin/ajoutUser";
	}
	@GetMapping("/planningSecretaire")
	public String planningSecretaire() {
		return "secretaire/planningSecretaire";
	}
	@GetMapping("/planningAgent")
	public String planningAgent() {
		return "agent/planningAgent";
	}
	
	@PostMapping("/accesApplicationSurPlace")
	public String accesApplicationSurPlace() {
		return "visiteur/accesApplicationSurPlace";
	}
	
	
	@GetMapping("/impressionBadgeMDPWifi")
	public String impressionBadgeMDPWifi() {
		return "visiteur/impressionBadgeMDPWifi";
	}
	
	@GetMapping("/planningPriseRDV")
	public String planningPriseRDV() {
		return "visiteur/planningPriseRDV";
	}
	
}
