package com.swabhavtechlabs.serailizeapp;

import java.io.Serializable;

public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int rollNumber;
	private String email;
	
	Student(String name, int rollNumber, String email) {
		this.name = name;
		this.rollNumber = rollNumber;
		this.email = email;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getRollNumber() {
		return this.rollNumber;
	}
	
	public String getEmail() {
		return this.email;
	}
}
