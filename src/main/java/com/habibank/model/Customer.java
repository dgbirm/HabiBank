/*
 * Copyright (c) 2020 as part of Bank, All rights reserved.
 * @author Dan Birmingham. Please reach out to dgbirm@gmail.com
 * Date generated: Jul 29, 2020
 * @version jdk-14
 */
package com.habibank.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


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
	
	@Id @GeneratedValue 
	private final  Integer customerID; //Add transient like the field in account?
	
	private String customerName = "";	
    private String password = "";
    private String userName = "";

	private String email = "";

	private String address= ""; private String city = ""; private String country = "";
	/**
	 * @param customerID id of the customer
	 * @param customerName given name of the customer. "" by default
	 * @param username  customer username for login
	 * @param email a email to identify a customer or username. cant be null
	 * @param password password to access customer details
	 * @param address customer addr. Empty String if unknown
	 * @param city city of residence. Empty String if unknown
	 * @param country country of residence. Empty String if unknown
	 */
	
	//Constructors 
	public Customer(Integer customerID, String customerName, 
			String password, String userName, String email, String address, String city, String country) {
		this.customerID = customerID;
		this.customerName = customerName;
		this.email = email;
		this.password = password;
		this.userName = userName;
		this.address = address;
		this.city = city;
		this.country = country;
	}
	
	public Customer(Integer customerID, String customerName, String address, String city) {
		this.customerID = customerID;
		this.customerName = customerName;
		this.address = address;
		this.city = city;
	}
	
	public Customer(Integer customerID, String customerName) {
		this.customerID = customerID;
		this.customerName = customerName;
	}
	
//toString
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", address=" + address
				+ ", city=" + city + ", country=" + country + "]";
	}
//getterSetters
	/**
	 * @return the customerName
	 */
	public synchronized String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public synchronized void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the address
	 */
	public synchronized String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public synchronized void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public synchronized String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public synchronized void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the country
	 */
	public synchronized String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public synchronized void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the customerID
	 */
	public synchronized Integer getCustomerID() {
		return customerID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
