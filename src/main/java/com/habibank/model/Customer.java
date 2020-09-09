/*
 * Copyright (c) 2020 as part of HabiBank, All rights reserved.
 * @author Chris Jabbour
 * @author Matt Knudsvig
 * @author Dan Birmingham. Please reach out to dgbirm@gmail.com
 * @author Natasha Ng.
 * Date generated: Aug 28, 2020
 * @version jdk-11
 */
package com.habibank.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

//TODO: Set the table relationships
/**
 * The class Customer: describes a Customer object
 * Reuse code from user to add email and username and password
 */
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	// Thought:
	// TODO Should we add a password property for a customer to login? for login

	private static final long serialVersionUID = 2639005257252900439L;

	@Id
	@GeneratedValue
	@Column(updatable = false)
	private Long custID;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(name = "cust_acct",  joinColumns = @JoinColumn(name = "custID"), inverseJoinColumns = @JoinColumn(name = "acctID"))
	@JsonIgnore
	private Set<Account> accounts = new HashSet<>();

	private String fullName = "";
	private String userName = "";
	@Email
	private String email = "";
	private String address = "";

	@Column(length = 10)
	private String phoneNumber;

	/**
	 * @param custID   id of the customer
	 * @param custName given name of the customer. "" by default
	 * @param fullname customer fullname for login
	 * @param password password for customer account
	 * @param email    a email to identify a customer or fullname. cant be null
	 * @param address  customer addr. Empty String if unknown
	 */

	// Constructors
	public Customer(){}


public Customer(String userName, String fullName, String email, String address,
			String phoneNumber) {
		this.userName = userName;
		this.fullName = fullName;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	} 
	
	public synchronized Set<Account> getAccounts() {
		return this.accounts;
	}
	
	public synchronized boolean addCustomerToAccount(Account acct) {
		return this.getAccounts().add(acct) &&
				acct.getCustomersOnAccount().add(this);
			}
	
	public synchronized boolean removeCustomerFromAccount(Account acct) {
		return this.getAccounts().remove(acct) &&
				acct.getCustomersOnAccount().remove(this);
	}
	
//toString
	@Override
	public String toString() {
		return "Customer [custID=" + custID
				+ ", userName=" + userName + ", fullName=" + fullName + ", email=" + email + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	

//hashcode
	@Override
	public int hashCode() {
		return Objects.hash(custID);
	}

//equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(custID, other.custID);
	}

//GetterSetters
	public synchronized Long getCustomerID() {
		return custID;
	}

	public synchronized String getUserName() {
		return userName;
	}

	public synchronized void setUserName(String userName) {
		this.userName = userName;
	}

	public synchronized String getFullName() {
		return fullName;
	}

	public synchronized void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public synchronized String getEmail() {
		return email;
	}

	public synchronized void setEmail(String email) {
		this.email = email;
	}

	public synchronized String getAddress() {
		return address;
	}

	public synchronized void setAddress(String address) {
		this.address = address;
	}

	public synchronized String getPhoneNumber() {
		return phoneNumber;
	}

	public synchronized void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

//getterSetters
	
	

}
