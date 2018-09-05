package com.techlabs.transaction;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnection {
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Loaded driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/transaction?"+"user=manu&password=manu");
			System.out.println("Connected successfully");
			//System.out.println(connection.getClass());
		} catch(Exception ex) {
			System.out.println("Error loading driver");
		}
		return connection;
	}
}
