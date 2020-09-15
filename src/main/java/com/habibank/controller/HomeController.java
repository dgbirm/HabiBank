package com.habibank.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@Profile("prod")
public class HomeController {
		//Not sure if we need a custom UI controller in different contorller  
		
		@GetMapping("/") //flag '', '/', 'index' to support [react-app] index
		private String getRedirectToProile() {
			return "redirect:/";
		}
		
	@GetMapping("/profile") //flag '', '/', 'index' to support [react-app] index
	private String getRedirectToProfile() {
		return "redirect:/profile";
	}

	@GetMapping("/register")
	private String redirectToRegister() {
		return "redirect:/register";
	}
	
}
