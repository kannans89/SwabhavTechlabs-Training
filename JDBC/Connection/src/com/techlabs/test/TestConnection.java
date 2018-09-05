package com.techlabs.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class TestConnection {
	public static ResultSet getDatabases(Connection connection) { 
		ResultSet result = null;
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
			result = statement.executeQuery("SHOW DATABASES");
			return result;
		} catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
	
	public static void printDatabases(ResultSet databases) throws SQLException {
		while(databases.next()) {
			System.out.println(databases.getString("Database"));
		}
	}
	
	public static void printDetails(Connection connection) throws SQLException {
		System.out.println("Database: "+connection.getCatalog());
		ResultSet tables = getTables(connection);
		printTables(tables);
	}
	
	public static void printTables(ResultSet tables) throws SQLException {
		System.out.println("List of Tables");
		while(tables.next()) {
			 String tableName = tables.getString("TABLE_NAME");
		      System.out.println("tableName=" + tableName);
		}
	}
	
	public static ResultSet getTables(Connection connection) throws SQLException {
		ResultSet tables = null;
		DatabaseMetaData md = (DatabaseMetaData) connection.getMetaData();
		tables = md.getTables("swabhav", null, "%", new String[]{"TABLE"});
		
		return tables;
	}
	public static void main(String[] args) throws SQLException {
		CreateConnection create = new CreateConnection();
		Connection connection = create.getConnection();
		TestStatement statement = new TestStatement(connection);
		ResultSet students = statement.executeStateMent();
		TestResult result = new TestResult();
		Scanner sc=new Scanner(System.in);
	
		System.out.println("Enter roll number");
		//String roll = sc.nextLine();
		//ResultSet student = statement.getStudentDetails(roll);
		//result.displayStudentData(student);
		
		TestSQLInjection sqlInj = new TestSQLInjection(connection);
		int roll1 = sc.nextInt();
		ResultSet student1 = sqlInj.getStudentDetailsByPstatement(roll1);
		result.displayStudentData(student1);
		//result.displayResult(students);
		//ResultSet databases = getDatabases(connection);
		
		//printDatabases(databases);
		//printDetails(connection);
	}
}
