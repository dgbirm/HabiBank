package com.habibank.model;

import java.io.Serializable;

import javax.persistence.*;
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
public class User implements Serializable{

	private static final long serialVersionUID = 1125610460833462892L;

	@Transient
	@Autowired
	private CustomerRepository custRepo;


	//Changed this line trying to fix the error but got more errors
	@Id
	private Long custID;
	
	@OneToOne
	@JoinColumn(name = "custID")
	@MapsId
	private Customer cust;
	
	
	//TODO: Check with truelove about these annotations
	private String userName;

	private String email;

	@Size(max = 120)
	private String password;   

	/* @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>(); */

	public User() {}

	public User(Long custID, String password) {
		this.custID = custID;
		this.userName = this.custRepo.findById(custID).get().getUserName();
		this.email = this.custRepo.findById(custID).get().getEmail();
		this.password = password; //want to at some point store hash of password?
	
	}
	
//toString
	@Override
	public String toString() {
		return "User [custID=" + custID + ", userName=" + userName + ", email=" + email + "]";
	}

	public synchronized Long getCustID() {
		return custID;
	}

	public synchronized void setCustID(Long custID) {
		this.custID = custID;
	}

	public synchronized String getUserName() {
		return userName;
	}

	public synchronized void setUserName(String username) {
		this.userName = username;
	}

	public synchronized String getEmail() {
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