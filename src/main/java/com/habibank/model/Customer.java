/*
 * Copyright (c) 2020 as part of Bank, All rights reserved.
 * @author Dan Birmingham. Please reach out to dgbirm@gmail.com
 * Date generated: Jul 29, 2020
 * @version jdk-14
 */
package com.habibank.model;

import java.io.Serializable;

/**
 * The class Customer: describes a Customer object 
 */
public class Customer implements Serializable {

	private static final long serialVersionUID = 2639005257252900439L;
	private final Integer customerID;
	private String customerName = "";
	private String address= "";
	private String city = "";
	private String country = "";
	/**
	 * @param customerID id of the customer
	 * @param customerName given name of the customer. "" by default
	 * @param address customer addr. Empty String if unknown
	 * @param city city of residence. Empty String if unknown
	 * @param country country of residence. Empty String if unknown
	 */
	
	//Constructors 
	public Customer(Integer customerID, String customerName, String address, String city, String country) {
		this.customerID = customerID;
		this.customerName = customerName;
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
}
