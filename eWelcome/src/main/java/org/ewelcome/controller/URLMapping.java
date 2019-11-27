package org.ewelcome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class URLMapping {

	@GetMapping("/")
	public String get() {
		return "index";
	}
}
