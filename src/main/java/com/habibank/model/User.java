package com.habibank.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.habibank.repo.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * two main models for Authentication (User) & Authorization (Role). They have a
 * one to one. like one customer has one user parent class
 * 
 * A user can have many roles or access levels
 * 
 * User: id, username, email, password, roles Role: id, name
 */

@Entity
@Table(name = "users")
/***
 * Model for Authenication. Contains info pertinant to authentication
 */
public class User {

	@Autowired
	private CustomerRepository custRepo;


	//Changed this line trying to fix the error but got more errors
	@Id
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "custID" /*,nullable=false*/)
	//@Column(updatable = false)
	private long userID;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userName")
	private String userName;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "email")
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;   

	/* @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>(); */

	public User() {}

	public User(Long userID, String password) {
		this.userID = userID;
		this.userName = this.custRepo.findById(this.userID).get().getUserName();
		this.email = this.custRepo.findById(this.userID).get().getEmail();
		this.password = password; //want to at some point store hash of password?
	
	}

	public Long getUserID() {
		return userID;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}