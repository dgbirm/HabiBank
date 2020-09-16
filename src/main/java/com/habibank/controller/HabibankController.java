package com.habibank.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.view.RedirectView;

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

	// should this be done on the front-end?
	// @RequestMapping(value = {
	// 	"index"
	// }) //flag '', '/', 'index' to support [react-app] index
	// private RedirectView index() {
	// 	return new RedirectView("");
	// }

	//login request
	@GetMapping("/login/{userName}/{password}")
	public Customer loginAttempt(@PathVariable("userName")String userName, @PathVariable("password") String password) {
		return this.custRepo.findByUserNameAndPassword(userName,password);
	}

	//get accounts and transactions by customer
	@GetMapping("customer/{custID}/accounts") //Needs fine tuning
	public List<Object[]> getCustomerAccounts(@PathVariable("custID") Long custID) {
		return this.custRepo.getCustomerAccounts(custID);
	}
	@GetMapping("customer/{custID}/transactions")
		 public List<Object[]> getCustomerTransactions(@PathVariable("custID") Long custID) {
		 	return this.custRepo.getCustomerTransactions(custID) ;
		 }










	@PostMapping("/register/{userName}/{password}")
	public Customer registerCustomer(@RequestBody Customer c){
		if(custRepo.equals(c.getUserName()) && custRepo.equals(c.getEmail())){
			return null;
			//give a failure and not post
		}
		else {
			return custRepo.save(c);
			//save this information
		}
	}


	

	//get mapping to show transactions by customerId

	//post mapping deposit by customer/username/accountid 

	//post mapping withdraw by customer/username/accountid 


	//put mapping to update customer information




	//some way to logout



	
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

//create customer	
	@PostMapping("api/customers")
	private ResponseEntity<?> createCust(@RequestBody Customer c) {
		Customer createdCustomer = new Customer(
				c.getUserName(),c.getFullName(),c.getEmail(), c.getPassword(),
				c.getAddress(),c.getPhoneNumber());
		this.custRepo.saveAndFlush(createdCustomer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdCustomer.getCustomerID()).toUri();
		return ResponseEntity.created(location).build();
	}
//Login as customer

}
