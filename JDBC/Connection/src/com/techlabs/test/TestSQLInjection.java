package com.techlabs.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestSQLInjection {
	Connection connection;
	public TestSQLInjection(Connection connection) {
		this.connection = connection;
	}
	public ResultSet getStudentDetailsByPstatement(int roll) throws SQLException {
		ResultSet student = null;
		String query = "select * from student where roll_no=?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, roll);
		student = statement.executeQuery();
		return student;
	}
}
