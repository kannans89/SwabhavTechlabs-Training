package com.swabhavtechlabs.contactsApp;

import java.io.Serializable;

public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String email;
	
	Contact(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName= lastName;
		this.email = email;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getEmail() {
		return this.email;
	}
}
