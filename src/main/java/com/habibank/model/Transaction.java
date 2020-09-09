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

import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class Transaction.
 */
@Entity
@Table(name="transaction")
public class Transaction {
	@Id
	@GeneratedValue
	@Column(updatable = false)
	private Long transactionID;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "acctID")
	private Account acct;
	
	private Double amountTransfered;
	private String memo="";
	@Column(updatable = false)
	private Timestamp ts = Timestamp.valueOf(LocalDateTime.now());
	/**
	 * @param transactionID
	 * @param amountTransfered
	 * @param Memo "A description of transaction deposit or withdrawal"
	 * @param acctID
	 * @param ts Time the transaction object was constructed
	 */
	
//Constructors
	public Transaction(Account acct, Double amountTransfered, String memo) {
		this.acct = acct;
		this.amountTransfered = amountTransfered;
		this.memo = memo;
	}
	
	public Transaction() {}


//toString
	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", acct=" + acct + ", amountTransfered="
				+ amountTransfered + ", memo=" + memo + ", ts=" + ts + "]";
	}

//GetterSetters
	public synchronized Long getTransactionID() {
		return transactionID;
	}

	public synchronized Account getAcct() {
		return acct;
	}

	public synchronized void setAcct(Account acct) {
		this.acct = acct;
	}

	public synchronized Double getAmountTransfered() {
		return amountTransfered;
	}

	public synchronized void setAmountTransfered(Double amountTransfered) {
		this.amountTransfered = amountTransfered;
	}

	public synchronized String getMemo() {
		return memo;
	}

	public synchronized void setMemo(String memo) {
		this.memo = memo;
	}

	public synchronized Timestamp getTs() {
		return ts;
	}


}
