package com.mvc.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.model.Student;
import com.mvc.utitlity.CreateConnection;
import com.mysql.cj.protocol.Resultset;

public class StudentRepository {
	CreateConnection createConnection = null;
	Connection connection = null;
	
	public StudentRepository() {
		createConnection = CreateConnection.getConnectionInstance();
		connection = createConnection.getConnection();
	}
	
	public Student getStudent(String id) throws SQLException {
		Student student = null;
		int newId = Integer.parseInt(id);
		
		String query = "select * from student where roll_no=?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, newId);
		
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			System.out.println(result.getString("roll_no"));
			student = new Student(Integer.parseInt(result.getString("roll_no")), result.getString("first_name"), result.getString("last_name"), Double.parseDouble(result.getString("cgpa")), result.getString("roll_no"));
		}
		System.out.println("In getStudent");
		return student;
	}
	
	public void addStudent(Student student) throws SQLException {
		String id = student.getCollegeId();
		String first_name = student.getFirstName();
		String last_name = student.getLastName();
		double cgpa = student.getCgpa();
		String collegeId = student.getCollegeId();
		
		String query = "INSERT INTO student(roll_no, first_name, last_name, cgpa, college_id) VALUES(?, ?, ?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(query);
		
		statement.setString(1, id);
		statement.setString(2, first_name);
		statement.setString(3, last_name);
		statement.setDouble(4, cgpa);
		statement.setString(5, collegeId);
		statement.execute();
		System.out.println("Added student successfully");
	}
	
	public List<Student> getStudents() throws SQLException {
		List<Student> students = new ArrayList<Student>();
		PreparedStatement statement = connection.prepareStatement("select * from student");
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			students.add(new Student(Integer.parseInt(result.getString("roll_no")), result.getString("first_name"), result.getString("last_name"), Double.parseDouble(result.getString("cgpa")), result.getString("college_id")));
		}
		return students;
	}
	
	public void updateStudent(String id, Student updatedStudent) throws SQLException {
		int newId = Integer.parseInt(id);
		String query = "update student set first_name = ?, last_name=?, cgpa=?, college_id=? where roll_no = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		
		
		statement.setString(1, updatedStudent.getFirstName());
		statement.setString(2, updatedStudent.getLastName());
		statement.setDouble(3, updatedStudent.getCgpa());
		statement.setString(4, updatedStudent.getCollegeId());
		statement.setInt(5, newId);
		statement.executeUpdate();
	}
	
	public List<Student> getStudentsByCollegeId(String collegeId) throws SQLException{
		List<Student> students = new ArrayList<>();
		int id = Integer.parseInt(collegeId);
		String query = "select * from student where college_id = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		
		statement.setInt(1, id);
		
		ResultSet result = statement.executeQuery();
		System.out.println("Getting students from college id");
		while(result.next()) {
			String roll_no = result.getString("roll_no");
			String first_name = result.getString("first_name");
			String last_name = result.getString("last_name");
			String cgpa = result.getString("cgpa");
			students.add(new Student(Integer.parseInt(roll_no), first_name, last_name, Double.parseDouble(cgpa), collegeId));
		}
		return students;
	}
}
