package com.techlabs.model;

public class College {
	private int id;
	String name;
	String loc;
	
	public College() {}
	public College(int id, String name, String loc) {
		this.name = name;
		this.id = id;
		this.loc = loc;
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
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
}
