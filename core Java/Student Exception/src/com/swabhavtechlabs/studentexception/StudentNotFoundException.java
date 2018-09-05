package com.swabhavtechlabs.studentexception;

public class StudentNotFoundException extends Exception{
	private String details;
	public StudentNotFoundException(String details) {
		// TODO Auto-generated constructor stub
		this.details = details;
	}
	
	public String toString() {
		return "StudentNotFoundException ["+details+"]";
	}
}
