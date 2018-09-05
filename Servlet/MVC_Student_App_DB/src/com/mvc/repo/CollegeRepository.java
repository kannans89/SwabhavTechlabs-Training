package com.mvc.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mvc.model.College;
import com.mvc.utitlity.CreateConnection;

public class CollegeRepository {
	CreateConnection createConnection = null;
	Connection connection = null;
	
	public CollegeRepository() {
		createConnection =CreateConnection.getConnectionInstance();
		connection = createConnection.getConnection();
	}
		
	
	
	public List<College> getColleges() throws SQLException {
		List<College> colleges = new ArrayList<College>();
		PreparedStatement statement = connection.prepareStatement("select * from college");
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			colleges.add(new College(result.getString("id"), result.getString("name"), result.getString("location")));
		}
		return colleges;
	}
	
	public Map<String, String> getCollegeIdNames() throws SQLException{
		Map<String, String> colleges = new HashMap<>();
		PreparedStatement statement = connection.prepareStatement("select id, name from college");
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			colleges.put(result.getString("id"), result.getString("name"));
		}
		return colleges;
	}
}
