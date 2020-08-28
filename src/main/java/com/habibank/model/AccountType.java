/*
 * Copyright (c) 2020 as part of Bank, All rights reserved.
 * @author Dan Birmingham. Please reach out to dgbirm@gmail.com
 * Date generated: July 30, 2020
 * @version jdk-14
 */
package com.habibank.model;

public enum AccountType {
	CHECKING("checking") , SAVINGS("savings"), BROKERAGE("brokerage");

	private String readable;
	
	AccountType(String rdble) {
		this.readable = rdble;
	}
	
	@Override
	public String toString() {
		return readable;
	}
}
