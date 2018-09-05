package com.techlabs.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnection {
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Loaded driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/swabhav?"+"user=manu&password=manu");
			System.out.println("Connected successfully");
			//System.out.println(connection.getClass());
		} catch(Exception ex) {
			System.out.println("Error loading driver");
		}
		return connection;
	}
}
