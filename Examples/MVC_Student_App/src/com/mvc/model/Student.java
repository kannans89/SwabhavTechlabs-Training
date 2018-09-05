package com.mvc.model;

public class Student {
	private String firstName, lastName;
	private double cgpa;
	private int id;
	private String collegeId;
	private static int idCounter = 100;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student(String firstName, String lastName, double cgpa, String collegeId){
		this.id = idCounter++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cgpa = cgpa;
		this.collegeId = collegeId;
	}

	public String getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
}
