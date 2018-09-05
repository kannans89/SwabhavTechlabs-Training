package com.swabhavtechlabs.comparator;

import java.util.Comparator;

public class Jobcandidate{
	private int id;
	private double salary;
	private String name;
	private int age;
	
	public Jobcandidate(int id, double salary, String name, int age) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.salary = salary;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return this.id;
	}
	
	public double getSalary() {
		return this.salary;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}

}
