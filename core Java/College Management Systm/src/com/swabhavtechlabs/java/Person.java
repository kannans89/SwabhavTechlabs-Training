package com.swabhavtechlabs.java;

import java.net.SocketImpl;
import java.text.SimpleDateFormat;

public class Person {
	private int id;
	private SimpleDateFormat dateOfBirth;
	private String name;
	private String address;
	
	
	Person(int id, String name, String address, SimpleDateFormat date){
		this.id = id;
		this.name = name;
		this.address = address;
		this.dateOfBirth = date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public SimpleDateFormat getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(SimpleDateFormat dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
