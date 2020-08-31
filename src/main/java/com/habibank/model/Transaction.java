/*
 * Copyright (c) 2020 as part of Bank, All rights reserved.
 * @author Dan Birmingham. Please reach out to dgbirm@gmail.com
 * Date generated: Jul 29, 2020
 * @version jdk-14
 */
package com.habibank.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The Class Transaction.
 */
public class Transaction {
	private final @Id @GeneratedValue Integer transactionID;
	// TODO Consideration should we add sourceAccountId and a destinationAccountId?
	//private Double initialBalance;
	//private Double finalBalance;
	private Double amountTransfered;
	private String memo="";
	private Integer acctID;
	private Timestamp ts = Timestamp.valueOf(LocalDateTime.now());;
	/**
	 * @param transactionID
	 * @param amountTransfered
	 * @param Memo "A description of transaction deposit or withdrawal"
	 * @param acctID
	 * @param ts Time the transaction object was constructed
	 */
	
	//Constructors
	public Transaction(Integer transactionID, Double amountTransfered, String memo, Integer acctID, Timestamp ts) {
		this.transactionID = transactionID;
		this.amountTransfered = amountTransfered;
		this.memo = memo;
		this.acctID = acctID;
		this.ts = ts;
	}
	
	public Transaction(Integer transactionID, Double amountTransfered, String memo, String destination, Integer acctID) {
		this.transactionID = transactionID;
		this.amountTransfered = amountTransfered;
		this.memo = memo;
		this.acctID = acctID;
	}
	

	public Transaction(Integer transactionID, Double ammountTransfered, Integer acctID) {
		this.transactionID = transactionID;
		this.amountTransfered = ammountTransfered;
		this.acctID = acctID;
	}

	//toString
	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", ammountTransfered=" + amountTransfered
				+ ", memo=" + memo + ", acctID=" + acctID + ", ts=" + ts + "]";
	}
	
	
	//GetterSetters
	public synchronized Double getAmmountTransfered() {
		return amountTransfered;
	}

	public synchronized void setAmmountTransfered(Double ammountTransfered) {
		this.amountTransfered = ammountTransfered;
	}

	public synchronized String getMemo() {
		return memo;
	}

	public synchronized void setDestination(String memo) {
		this.memo = memo;
	}

	public synchronized Timestamp getTs() {
		return ts;
	}

	public synchronized void setTs(Timestamp ts) {
		this.ts = ts;
	}

	public synchronized Integer getTransactionID() {
		return transactionID;
	}

	public synchronized Integer getAcctID() {
		return acctID;
	}
	
	
}
