package com.habibank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    	//Not sure if we need a custom UI controller in different contorller  
	@RequestMapping(value = "/") //flag '', '/', 'index' to support [react-app] index
	private String index() {
		return "index";
	}
}
