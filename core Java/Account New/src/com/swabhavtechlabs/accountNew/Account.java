package com.swabhavtechlabs.accountNew;

abstract public class Account {
	private int accountNumber;
	private String name;
	private double balance;
	
	public Account(int ac, double balance, String name){
		this.accountNumber = ac;
		this.balance = balance;
		this.name = name;
	}
	abstract boolean withDraw(int amount);
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
