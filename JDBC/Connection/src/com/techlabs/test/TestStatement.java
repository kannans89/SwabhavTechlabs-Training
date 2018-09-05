package com.techlabs.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestStatement {
	Statement statement;
	PreparedStatement pStatement;
	Connection connection;
	public TestStatement(Connection connection) throws SQLException {
		statement = connection.createStatement();
		this.connection = connection;
	}
	
	public ResultSet executeStateMent() throws SQLException {
		ResultSet result = null;
		
		System.out.println(statement.getClass());
		result = statement.executeQuery("select * from student");
		return result;
	}
	
	public ResultSet getStudentDetails(String roll) throws SQLException {
		ResultSet student = null;
		student = statement.executeQuery("select * from student where roll_no="+roll);
		return student;
	}
	
	
}
