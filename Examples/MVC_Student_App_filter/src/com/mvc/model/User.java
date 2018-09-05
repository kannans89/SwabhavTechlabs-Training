package com.mvc.model;

public class User {
	private String username, password;
	private int id;
	private static int idCounter = 100;
	public User(String name, String password) {
		this.id = idCounter++;
		this.username = name;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
