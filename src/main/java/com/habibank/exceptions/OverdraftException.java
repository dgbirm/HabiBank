/*
 * Copyright (c) 2020 as part of HabiBank, All rights reserved.
 * @author Chris Jabbour
 * @author Matt Knudsvig
 * @author Dan Birmingham. Please reach out to dgbirm@gmail.com
 * @author Natasha Ng.
 * Date generated: Sept 2, 2020
 * @version jdk-11
 */
package com.habibank.exceptions;

import com.habibank.model.Account;

public class OverdraftException extends Exception {

	private static final long serialVersionUID = -123617544819940871L;

	private Account acct;
	private Double currentBalance;
	
	/**
	 * Format message.
	 *
	 * @param acct      the account ID
	 * @param currentBalance the current balance
	 * @return the formatted error message
	 */
	private static String formatMessage(Account acct, Double currentBalance) {
		return String.format("Your transaction is unable to be completed %n"
				+ "because you are not allowed to credit your this account. %n"
				+ "Your current balance for account %d is %.2f", acct, currentBalance);	
	}
	
	//Constructors
	public OverdraftException(Account acct, Double currentBalance) {
		super(formatMessage(acct, currentBalance));
		this.acct = acct;
		this.currentBalance = currentBalance;
	}

	public OverdraftException(Account acct, Double currentBalance, Throwable cause) {
		super(formatMessage(acct, currentBalance), cause);
		this.acct = acct;
		this.currentBalance = currentBalance;
	}

	public OverdraftException(Account acct, Double currentBalance, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(formatMessage(acct, currentBalance), cause, enableSuppression, writableStackTrace);
		this.acct = acct;
		this.currentBalance = currentBalance;
	}
	
	/**
	 * Gets the account ID.
	 *
	 * @return the account ID
	 */
	public Account getAccount() {
		return this.acct;
	}
	
	/**
	 * Gets the current balance.
	 *
	 * @return the current balance
	 */
	public Double getCurrentBalance() {
		return this.currentBalance;
	}

}
