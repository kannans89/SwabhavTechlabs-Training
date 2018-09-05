package com.mvc.model;

public class College {
	private String college_id, name, location;
	
	public College(String college_id, String name, String location) {
		this.college_id = college_id;
		this.name = name;
		this.location = location;
	}

	public String getCollege_id() {
		return college_id;
	}

	public void setCollege_id(String college_id) {
		this.college_id = college_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
