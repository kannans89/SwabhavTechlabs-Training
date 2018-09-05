package com.mvc.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mvc.model.Student;
import com.mvc.repo.StudentRepository;

public class StudentService {
	private List<Student> students;
	static StudentService studentService = null;
	StudentRepository studentRepo = null;
	
	private StudentService() {
		students = new ArrayList<Student>();
		studentRepo = new StudentRepository();
		createStudents();
	}
	
	public static StudentService getStudentService() {
		if(studentService == null) {
			studentService = new StudentService();
			System.out.println("Inside object creation of Student Service");
			return studentService;
		}
		return studentService;
	}
	
	public List<Student> getStudents() throws SQLException {		
		return studentRepo.getStudents();
	}
	
	public void createStudents() {
		students.add(new Student(101, "Manoj", "B", 9.0, "c101"));
		students.add(new Student(102, "Varshil", "Mehta", 8.0, "c102"));
		students.add(new Student(103, "Madhuri", "abc", 8.5, "c103"));
	}
	
	public void addStudent(Student student) throws SQLException {
		this.studentRepo.addStudent(student);
	}
	
	public Student getSingleStudent(String id) throws SQLException {
		return this.studentRepo.getStudent(id);
	}
	
	public void updateStudent(String id, Student updatedStudent) throws SQLException {
		this.studentRepo.updateStudent(id, updatedStudent);
	}
	
	public List<Student> getStudentsByCollegeId(String collegeID) throws SQLException {
		return this.studentRepo.getStudentsByCollegeId(collegeID);
	}
}
