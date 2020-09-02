/*
 * Copyright (c) 2020 as part of Bank, All rights reserved.
 * @author Dan Birmingham. Please reach out to dgbirm@gmail.com
 * Date generated: Jul 29, 2020
 * @version jdk-14
 */
package com.habibank.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;


//TODO: Set the table relationships
/**
 * The class Customer: describes a Customer object 
 */
@Entity
@Table(name="customer")
public class Customer implements Serializable {

	// Thought: 
	//TODO Should we add a password property for a customer to login? for login

	private static final long serialVersionUID = 2639005257252900439L;
	
	@Id
	@GeneratedValue 
	private Integer custID = null; 
	@ManyToMany(fetch = FetchType.LAZY, 
				cascade= { 
					CascadeType.MERGE,
					CascadeType.PERSIST
				})
	@JoinTable(
			name = "cust_acct",
			joinColumns = @JoinColumn(name = "custID"),
			inverseJoinColumns = @JoinColumn(name = "acctID")
			)
	private Set<Account> accounts = new HashSet<>();
	
	private String userName = "";
	private String fullName = "";
	private String email = "";
	//TODO: address class?
	private String address= "";
	//TODO: @Phone annotation
	private PhoneNumber phoneNumber;


	/**
	 * @param custID id of the customer
	 * @param custName given name of the customer. "" by default
	 * @param fullname  customer fullname for login
	 * @param email a email to identify a customer or fullname. cant be null
	 * @param address customer addr. Empty String if unknown
	 */
	
//Constructors 
	public Customer(String userName, String fullName, String email, String address, PhoneNumber phoneNumber) {
		this.userName = userName;
		this.fullName = fullName;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	public Customer() {}
	
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
	
//GetterSetters
	public synchronized Integer getCustomerID() {
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

	public synchronized PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public synchronized void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

//getterSetters
	
	

}
