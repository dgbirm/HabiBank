package com.habibank.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.habibank.model.Customer_Account;
import com.habibank.repo.AccountRepository;
import com.habibank.repo.Customer_AccountRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class HabibankController {
	
	@Autowired
	private AccountRepository acctRepo;
	@Autowired
	private Customer_AccountRepository c_aRepo;

	@RequestMapping(value = "/") //flag index to support root
	private String index() {
		return "index";
	}
	
	@GetMapping("api/accounts")
	private Iterable<Account> getAllAcct(Pageable pg) {
        return this.acctRepo.findAll(pg);
    }
	
//	@PostMapping("api/employees")
//	private ResponseEntity<?> createEmp(@RequestBody Account e) {
//		Account createdAccount = new Account(
//				e.getFullName(),e.getDep(),e.getJobTitle(), e.getYearlySalary());
//		this.acctRepo.saveAndFlush(createdAccount);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdAccount.getEmpID()).toUri();
//		return ResponseEntity.created(location).build();
//	}

}