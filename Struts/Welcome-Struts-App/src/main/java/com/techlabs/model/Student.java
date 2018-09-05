package com.techlabs.model;

public class Student {
	private String firstName = "";

	private String roll_no="";
	private String gender="";
	private double cgpi = 0.0;
	
	public Student() {}
	
	public Student(String firstname, String roll, String gen, double cgpi, int id) {
		this.firstName = firstname;
		this.roll_no = roll;
		this.gender = gen;
		this.cgpi = cgpi;
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getCgpi() {
		return cgpi;
	}

	public void setCgpi(double cgpi) {
		this.cgpi = cgpi;
	}

	private int id;

	public String getRoll_no() {
		return roll_no;
	}

	public void setRoll_no(String roll_no) {
		this.roll_no = roll_no;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String toString() {
		return "Name: " + getFirstName() + " " + "Roll No: " + getRoll_no() + " " + "Gender: " + getGender()
				+ " " + "Cgpi: " + getCgpi();
	}
}
