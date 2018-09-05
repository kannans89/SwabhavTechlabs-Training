package com.swabhavtechlabs.bankaccount;

public class InsufficientFundException extends Exception{
	private String details;
	public InsufficientFundException(String details) {
		this.details = details;
	}
	
	public String toString() {
		return "InsufficientFundException ["+details+"]";
	}
}
