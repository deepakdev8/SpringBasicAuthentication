package com.rapidvalue.app.model;

public class AccountRequest {
	
	private long accountNumber;
	
	private String ownerName;
	
	public AccountRequest() {
		super();
	}


	public AccountRequest(long accountNumber, String ownerName) {
		super();
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
	}


	public long getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}



	public String getOwnerName() {
		return ownerName;
	}



	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	
	
	

}
