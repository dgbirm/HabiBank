package com.habibank.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

// Using composite pk with jpa requires special ID class that is attached to 
// the entity class using the @IdClass annotation.
class c_aID {
	Integer acctID; 
	Integer custID;
}

@Entity
@IdClass(c_aID.class)
@Table(name="customer_account")
public class Customer_Account {
	
	private final @Id Integer acctID;
	private final @Id Integer custID;
	
	public Customer_Account(Integer acctID, Integer custID) {
		this.acctID = acctID;
		this.custID = custID;
	}

	@Override
	public String toString() {
		return "Customer_Account [acctID=" + acctID + ", custID=" + custID + "]";
	}

	public Integer getAcctID() {
		return acctID;
	}

	public Integer getCustID() {
		return custID;
	}
	
}