package com.habibank.model;

/*
 * Copyright (c) 2020 as part of HabiBank, All rights reserved.
 * @author Chris Jabbour
 * @author Matt Knudsvig
 * @author Dan Birmingham. Please reach out to dgbirm@gmail.com
 * @author Natasha Ng.
 * Date generated: Aug 28, 2020
 * @version jdk-14
 * 
 * Also known as an domain entity or entity object
 */


import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.habibank.model.AccountType;

@Entity
@Table(name="account")
public class Account implements Serializable {

	private static final long serialVersionUID = -776361010511187135L;
	
	//Should we add a parent or main customer id to account
	// @OneToMany
	// @JoinColumn(name = "acct_id")
	// private Account AccountOwner;
	@Id @GeneratedValue 
	private final Integer acctID;
	private Set<Integer> acctCustomerIDs = new HashSet<>();
	private Double acctBalance=0.0;
	private Enum<AccountType> acctType = AccountType.CHECKING;
	
	//Constructors
	/**
	 * @param acctID Unique id of the account
	 * @param acctCustomerIDs IDs of customers associated with the account
	 * @param acctPass Password for the account
	 * @param acctBalance Balance for the account. If not given, defaults to 0
	 * @param acctType type of the account (checking or savings)
	 */
	public Account(Enum<AccountType> acctType) {
		this.acctType = acctType;
	}
	
	public Account() {}

	public synchronized boolean addCustomerToAccount(Integer custID) {
		return this.acctCustomerIDs.add(custID);
	}
	
	public synchronized boolean removeCustomerFromAccount(Integer custID) {
		return this.acctCustomerIDs.remove(custID);
	}
	
	//GetterSetters
	/**
	 * @return the acctCustomerIDs
	 */
	public synchronized Set<Integer> getAcctCustomerIDs() {
		return acctCustomerIDs;
	}

	/**
	 * @return the acctBalance
	 */
	public synchronized Double getAcctBalance() {
		return acctBalance;
	}

	/**
	 * @return the acctType
	 */
	public synchronized Enum<AccountType> getAcctType() {
		return acctType;
	}

	/**
	 * @param acctType the acctType to set
	 */
	public synchronized void setAcctType(Enum<AccountType> acctType) {
		this.acctType = acctType;
	}

	/**
	 * @return the acctID
	 */
	public synchronized Integer getAcctID() {
		return acctID;
	}

	//toString
	@Override
	public String toString() {
		final int maxLen = 5;
		return "Account [acctID=" + acctID + ", acctCustomerIDs="
				+ (acctCustomerIDs != null ? toString(acctCustomerIDs, maxLen) : null)
				+ ", acctBalance=" + acctBalance + ", acctType=" + acctType.toString() + "]";
	}

	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}
}
