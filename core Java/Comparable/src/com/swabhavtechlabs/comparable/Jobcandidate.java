package com.swabhavtechlabs.comparable;

public class Jobcandidate implements Comparable{
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
	
	@Override
	public int compareTo(Object candidate) {
		Jobcandidate jobCandidate = (Jobcandidate) candidate;
		return this.id < jobCandidate.id ? -1 : this.id > jobCandidate.id ? 1 : 0;
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
