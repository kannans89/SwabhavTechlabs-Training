package com.swabhavtechlabs.java;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Proffessor extends Person{
	private int noOfHours;
	private double salary;
	
	public Proffessor(int id, String name, String address, SimpleDateFormat date, int hours) {
		super(id, name, address, date);
		this.setNoOfHours(hours);
	}

	public int getNoOfHours() {
		return noOfHours;
	}

	public void setNoOfHours(int noOfHours) {
		this.noOfHours = noOfHours;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
