package com.techlabs.test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestResult {
	public void displayResult(ResultSet students) throws SQLException {
		while(students.next()) {
			System.out.print(students.getString("roll_no")+"\t");
			System.out.print(students.getString("first_name")+"\t");
			System.out.print(students.getString("last_name")+"\t");
			System.out.print(students.getString("cgpa")+"\t");
			System.out.print(students.getString("college_id")+"\t");
			System.out.println();
		}
	}
	
	public void displayStudentData(ResultSet student) throws SQLException {
		while(student.next()) {
			String roll_no = student.getString("roll_no");
			String first_name = student.getString("first_name");
			String last_name = student.getString("last_name");
			String cgpa = student.getString("cgpa");
			String college_id = student.getString("college_id");
			System.out.println("roll_no: "+roll_no);
			System.out.println("First_name: "+first_name);
			System.out.println("Last_name: "+last_name);
			System.out.println("CGPA: "+cgpa);
		}
	}
}
