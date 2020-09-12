package com.habibank.controller;

import com.habibank.repo.AccountRepository;
import com.habibank.repo.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Might delete
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
	private AccountRepository acctRepo;
	@Autowired
    private CustomerRepository custRepo;
    

    //Trying to figure out if modelAndView works for react

    
}
