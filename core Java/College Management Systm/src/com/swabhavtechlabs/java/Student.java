package com.swabhavtechlabs.java;

import java.text.SimpleDateFormat;

public class Student extends Person{
	College college = new College();
	String[] courses;
	private Branch branchOfStudent;

	public Student(int id, String name, String address, SimpleDateFormat date, String[] courses, Branch branch){
		super(id, name, address, date);
		this.courses = courses;
		this.branchOfStudent = branch;
	}
}
