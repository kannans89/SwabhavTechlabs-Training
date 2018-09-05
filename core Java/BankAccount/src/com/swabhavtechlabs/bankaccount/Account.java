package com.swabhavtechlabs.bankaccount;

public class Account {
	private static int accountNumber = 100;
	private double balance;
	private String name;
	Account(String name, int accountNUmber, double balance) {
		this.name = name;
		this.balance = 1000+balance;
		this.accountNumber = accountNUmber;
	}
	
	Account(String name, int accountNumber) {
		this(name, accountNumber, 1000);
	}
	
	Account(String name, double balance) {
		this(name, ++accountNumber, balance);
	}
	
	Account(String name){
		this(name, ++accountNumber);
	}
	
	public void deposit(int amount) {
		this.balance += amount;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAccountNumber() {
		return this.accountNumber;
	}
	
	public int withDraw(double amount) throws InsufficientFundException{
		double remainingBalance = this.balance - amount;
		if(remainingBalance > 1000) {
			this.balance -= amount;
			return 1;
		}
		else {
			throw new InsufficientFundException("Insufficient fund available "+remainingBalance);
		}
	}
	
	public Account whoIsRich(Account account) {
		if(this.balance > account.balance) {
			return this;
		}
		return account;
	}
}
