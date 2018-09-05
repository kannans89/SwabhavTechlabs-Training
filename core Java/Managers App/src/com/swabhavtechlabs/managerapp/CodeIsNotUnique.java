package com.swabhavtechlabs.managerapp;

public class CodeIsNotUnique extends RuntimeException{
	String detail;
	
	public CodeIsNotUnique(String detail) {
		this.detail = detail;
	}
	
	public String toString() {
		return "Exception:CodeIsNotUnique["+this.detail+"]";
	}
}
