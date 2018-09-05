package com.mvc.service;

import java.util.ArrayList;
import java.util.List;
import com.mvc.model.Student;

public class StudentService {
	private List<Student> students;
	static StudentService studentService = null;
	
	private StudentService() {
		students = new ArrayList<Student>();
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
	
	public List<Student> getStudents() {		
		return students;
	}
	
	public void createStudents() {
		students.add(new Student("Manoj", "B", 9.0, "c101"));
		students.add(new Student("Varshil", "Mehta", 8.0, "c102"));
		students.add(new Student("Madhuri", "abc", 8.5, "c103"));
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}
	
	public Student getSingleStudent(String id) {
		int id1 = Integer.parseInt(id);
		for(Student student: students) {
			if(student.getId() == id1) {
				return student;
			}
		}
		return null;
	}
	
	public void updateStudent(String id, Student updatedStudent) {
		int id1 = Integer.parseInt(id);
		for(Student student: students) {
			if(student.getId() == id1) {
				student.setFirstName(updatedStudent.getFirstName());
				student.setLastName(updatedStudent.getLastName());
				student.setCgpa(updatedStudent.getCgpa());
			}
		}
	}
}
