package com.habibank.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.habibank.model.Account;
import com.habibank.model.Customer;
import com.habibank.model.Transaction;
import com.habibank.repo.AccountRepository;
import com.habibank.repo.CustomerRepository;
import com.habibank.repo.TransactionRepository;


/*
Designate as home page controller

ideas:

Habibank Index/home RestController (view all objects?)
	||||||
   (user login/registrationRest)
	|||||
CusotmerProfileRest  (there should be a login/registration logic in customer or in a seperate user profile)
    |||||||
AccountdetailsRest
	|||||||
TransactionsRest


*/

@CrossOrigin(origins = "http://localhost:3000")
@RestController

public class HabibankController {

	//Inject 
	@Autowired
	private AccountRepository acctRepo;
	@Autowired
	private CustomerRepository custRepo;
	@Autowired
	private TransactionRepository transRepo;


	//Add constructor to add all the needed repositories

	@RequestMapping(value = "/") //flag index to support root
	private String index() {
		return "index";
	}

	//Get all customers or view all customers  
	@GetMapping("api/customers")
	public Iterable<Customer> getAllCustomers(Pageable pg) {
        return this.custRepo.findAll(pg);
	}

	//Get all accounts of one customer or view all accounts
	@GetMapping("api/accounts")
	private Iterable<Account> getAllAcct(Pageable pg) {
        return this.acctRepo.findAll(pg);
	}
	
	//Get all transactions or view all transactions
	@GetMapping("api/transactions")
	private Iterable<Transaction> getAllTrans(Pageable pg) {
        return this.transRepo.findAll(pg);
	}

	//Get a specific account


	//Get customer




//create customer	
	@PostMapping("api/customers")
	private ResponseEntity<?> createEmp(@RequestBody Customer c) {
		Customer createdCustomer = new Customer(
				c.getUserName(),c.getFullName(),c.getEmail(),
				c.getAddress(),c.getPhoneNumber());
		this.custRepo.saveAndFlush(createdCustomer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdCustomer.getCustomerID()).toUri();
		return ResponseEntity.created(location).build();
	}

}