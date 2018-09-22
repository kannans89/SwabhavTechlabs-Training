package com.techlabs.model;

public class Employee {
	private int id;
	private String name;
	private String address;
	private Car car;
	private Home home;
	private Office office;
	
	public Employee() {}
	
	public Employee (int id, String name, String add, Car car, Home home, Office office) {
		this.id = id;
		this.name = name;
		this.address= add;
		this.car = car;
		this.home = home;
		this.office = office;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	
	
}
