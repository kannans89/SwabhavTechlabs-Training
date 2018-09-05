package com.mvc.model;

public class Student {
	private String firstName, lastName;
	private double cgpa;
	private int roll_no;
	private String collegeId;
	private static int idCounter = 100;
	public int getRollNo() {
		return roll_no;
	}

	public void setRollNo(int id) {
		this.roll_no = id;
	}

	public Student(int roll_no, String firstName, String lastName, double cgpa, String collegeId){
		this.roll_no = roll_no;
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
