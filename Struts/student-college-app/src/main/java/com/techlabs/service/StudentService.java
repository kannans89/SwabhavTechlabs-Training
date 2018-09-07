package com.techlabs.service;

import java.util.ArrayList;
import java.util.List;

import com.techlabs.model.Student;

public class StudentService {
	private List<Student> students = null;
	private static StudentService studentService = null;
	
	private StudentService() {
		students = new ArrayList<>();
		students.add(new Student("Manoj", "10", "Male", 10, 101, 1001));
//		students.add(new Student("Manoj", "11", 102));
//		students.add(new Student("Manoj", "12", 103));
	}
	
	public static StudentService getStudentService() {
		if(studentService == null) {
			studentService = new StudentService();
			return studentService;
		}
		return studentService;
	}
	
	public List<Student> getStudents() {
		return this.students;
	}
	
	public void addStudent(Student student) {
		this.students.add(student);
	}
	
	public Student getStudentById(String id) {
		int newId = Integer.parseInt(id);
		for(Student student: students) {
			if(student.getId() == newId) {
				return student;
			}
		}
		return null;
	}
	
	public void updateStudent(String id, Student student) {
		for(Student student1: students) {
			if(Integer.parseInt(id)==student1.getId()) {
				students.remove(student1);
				students.add(student);
			}
		}
	}
	
	public void deleteStudentById(String id) {
		Object[] obj = students.toArray();
		for(Object o: obj) {
			if(Integer.parseInt(id)==((Student) o).getId()) {
				students.remove(o);
			}
		}
	}
}
