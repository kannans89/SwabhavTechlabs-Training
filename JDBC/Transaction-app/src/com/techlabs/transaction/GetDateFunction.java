package com.techlabs.transaction;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetDateFunction {
	public void printDate(Connection connection) throws SQLException {
		String query = "{select getDate() from customer}";
		//String query = "{? = call  getDate()}";
		CallableStatement callStatement = connection.prepareCall(query);
		callStatement.registerOutParameter(1, java.sql.Types.DATE);
		callStatement.executeQuery();
		Date date = callStatement.getDate(1);
		System.out.println(date);
		
	}
}
