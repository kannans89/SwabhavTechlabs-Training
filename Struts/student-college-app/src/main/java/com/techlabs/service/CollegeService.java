package com.techlabs.service;

import java.util.ArrayList;
import java.util.List;

import com.techlabs.model.College;
import com.techlabs.model.Student;

public class CollegeService {
	private List<College> colleges = null;
	private static CollegeService collegeService = null;
	
	private CollegeService() {
		colleges = new ArrayList<>();
		colleges.add(new College(1001, "St John", "Palghar"));
		colleges.add(new College(1002, "St Joseph", "Bandra"));
		colleges.add(new College(1003, "St Agnel", "Mangalore"));
//		students.add(new Student("Manoj", "11", 102));
//		students.add(new Student("Manoj", "12", 103));
	}
	
	public static CollegeService getCollegeService() {
		if(collegeService == null) {
			collegeService = new CollegeService();
			return collegeService;
		}
		return collegeService;
	}
	
	public List<College> getColleges() {
		return this.colleges;
	}
	
	public void addStudent(College college) {
		this.colleges.add(college);
	}
	
	public College getCollegeById(String id) {
		int newId = Integer.parseInt(id);
		for(College college: colleges) {
			if(college.getId() == newId) {
				return college;
			}
		}
		return null;
	}
	
	public List<String> getCollegesNames() {
		List<String> collegeNames = new ArrayList<>();
		for(College college: colleges) {
			collegeNames.add(college.getName());
		}
		return collegeNames;
	}
	
	public int getCollegeID(String name) {
		int id = 0;
		for(College college: colleges) {
			if(name.equalsIgnoreCase(college.getName())){
				id = college.getId();
			}
		}
		return id;
	}
//	
//	public void updateStudent(String id, Student student) {
//		for(Student student1: students) {
//			if(Integer.parseInt(id)==student1.getId()) {
//				students.remove(student1);
//				students.add(student);
//			}
//		}
//	}
//	
//	public void deleteStudentById(String id) {
//		Object[] obj = students.toArray();
//		for(Object o: obj) {
//			if(Integer.parseInt(id)==((Student) o).getId()) {
//				students.remove(o);
//			}
//		}
//	}
}
