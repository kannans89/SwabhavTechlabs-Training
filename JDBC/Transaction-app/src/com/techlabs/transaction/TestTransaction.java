package com.techlabs.transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class TestTransaction {
	public static void main(String[] args) throws SQLException {
		CreateConnection createConnection = new CreateConnection();
		Connection dbConnection = createConnection.getConnection();
		Transaction transaction = new Transaction();
		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter order amount");
//		double amount = sc.nextDouble();
//		transaction.executeTransaction(dbConnection, amount);
		
		GetDateFunction date = new GetDateFunction();
		date.printDate(dbConnection);
	}
}
