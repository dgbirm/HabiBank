package com.habibank.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.habibank.model.Role.ERole;
import com.habibank.repo.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

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
public class User implements Serializable {

	private static final long serialVersionUID = 1125610460833462892L;

	@Transient
	@Autowired
	private CustomerRepository custRepo;

	@Id
	@GeneratedValue
	@Column(name = "user_ID")
	private Long userID;

	// These dont need to exist in user
	private String userName;

	private String email;

	@Size(max = 120)
	private String password;

	//TODO
	@Transient
	private Enum accessLevel = Role.ERole.ROLE_CUSTOMER; // make a getter and setter

	@OneToOne(mappedBy = "user")
	private Customer cust;

	 @Transient
	  @ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable( name = "user_roles", joinColumns = @JoinColumn(name = "user_ID"),
	 inverseJoinColumns = @JoinColumn(name = "role_id")) 
	 private Set<Role> roles = new HashSet<>();
	 

	public User() {
	}

	public User(Long ID, String password) {
		this.userID = ID;
		this.userName = this.custRepo.findById(ID).get().getUserName();
		this.email = this.custRepo.findById(ID).get().getEmail();
		this.password = password; // want to at some point store hash of password?

	}

	// toString
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", email=" + email + "]";
	}

	public synchronized Long getUserID() {
		return userID;
	}

	public synchronized void setUserID(Long userID) {
		this.userID = userID;
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


	//TODO Test
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
    
}