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
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.habibank.exceptions.OverdraftException;

@Entity
@Table(name = "account")
public class Account implements Serializable {

	private static final long serialVersionUID = -776361010511187135L;

	// Should we add a parent or main customer id to account
	// @OneToMany
	// @JoinColumn(name = "acct_id")
	// private Account AccountOwner;

	@Id
	@GeneratedValue
	@Column(updatable = false)
	private Long acctID;

	@ManyToMany(mappedBy = "accounts", cascade = {
			// CascadeType.MERGE,
			CascadeType.PERSIST })
	@JsonIgnore
	private Set<Customer> customersOnAccount = new HashSet<>();

	private Double acctBalance = 0.0;

	@Enumerated(EnumType.STRING)
	private AccountType acctType = AccountType.CHECKING;

	// Constructors
	/**
	 * @param acctID          Unique id of the account
	 * @param acctCustomerIDs IDs of customers associated with the account
	 * @param acctPass        Password for the account
	 * @param acctBalance     Balance for the account. If not given, defaults to 0
	 * @param acctType        type of the account (checking or savings)
	 */

	public Account(AccountType acctType) {
		this.acctType = acctType;
	}

/* 	public Account( BigInteger acctID, AccountType acctType, double acctBalance) {

		this.acctID = acctID.longValue();
		this.acctType = acctType;
		this.acctBalance = acctBalance;

	}
	 */
	public Account() {}
	
	public Set<Customer> getCustomers() {
		return this.customersOnAccount;
	}
	
	public Transaction deposit(Double ammount, String memo) {
		acctBalance += ammount;
		return new Transaction(this, ammount, memo);
	}
	
	public Transaction withdraw(Double ammount, String memo) {
		Double newBalance = acctBalance - ammount;
		try {
			if (newBalance < 0) {
				throw new OverdraftException(this, acctBalance);
			}
			acctBalance = newBalance;
			return new Transaction(this,0 - ammount, memo);
		} catch (OverdraftException e) {
			e.getMessage();
			return null;
		}
	}
	
//toString
	@Override
	public String toString() {
		final int maxLen = 10;
		return "Account [acctID=" + acctID + ", customersOnAccount="
				+ (customersOnAccount != null ? toString(customersOnAccount, maxLen) : null) + ", acctBalance="
				+ acctBalance + ", acctType=" + acctType + "]";
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

	
//hashcode	
	@Override
	public int hashCode() {
		return Objects.hash(acctID);
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
		Account other = (Account) obj;
		return Objects.equals(acctID, other.acctID);
	}

//GetterSetters
	/**
	 * @return the acctCustomerIDs
	 */
	public synchronized Set<Customer> getCustomersOnAccount() {
		return customersOnAccount;
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
	public synchronized AccountType getAcctType() {
		return acctType;
	}

	/**
	 * @param acctType the acctType to set
	 */
	public synchronized void setAcctType(AccountType acctType) {
		this.acctType = acctType;
	}

	/**
	 * @return the acctID
	 */
	public synchronized Long getAcctID() {
		return acctID;
	}

}
