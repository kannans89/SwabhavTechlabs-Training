package com.swabhavtechlabs.managerapp;

public class CTCNegetiveException extends RuntimeException{
String detail;
	
	public CTCNegetiveException(String detail) {
		this.detail = detail;
	}
	
	public String toString() {
		return "CTCNegetiveException["+this.detail+"]";
	}
}
