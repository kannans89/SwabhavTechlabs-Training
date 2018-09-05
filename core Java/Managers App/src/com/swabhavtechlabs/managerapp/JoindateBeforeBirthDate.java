package com.swabhavtechlabs.managerapp;

public class JoindateBeforeBirthDate extends RuntimeException{
	String detail;
	
	public JoindateBeforeBirthDate(String detail) {
		this.detail = detail;
	}
	
	public String toString() {
		return "Exception:JoindateBeforeBirthDate["+this.detail+"]";
	}
}
