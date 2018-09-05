package com.swabhavtechlabs.bankaccount;

import java.util.Scanner;

public class AccountTest {
	private static int noOfAccounts = 0;
	
	public static void printDetails(Account account) {
		System.out.println("Name: "+account.getName());
		System.out.println("Account number: "+account.getAccountNumber());
		System.out.println("Balance: "+account.getBalance());
		System.out.println("<---------------->");
	}
	
	public static void numberOfAcHolders(int number) {
		System.out.println("Number of account holders are "+number);
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result;
		
		Account account1 = new Account("Manoj", 1500.00);
		noOfAccounts++;
		printDetails(account1);
		account1.deposit(5000);
		printDetails(account1);
		try {
			result = account1.withDraw(8000);
		} catch(InsufficientFundException e) {
			System.out.println(e);
		}
		
		Account account2 = new Account("Anil");
		noOfAccounts++;
		printDetails(account2);
		account2.deposit(1000);
		printDetails(account2);
		
		numberOfAcHolders(AccountTest.noOfAccounts);
		Account richAccount = account1.whoIsRich(account2);
		System.out.println(richAccount.getName()+" has more amount and balance is "+richAccount.getBalance());
	}
}
