package com.swabhavtechlabs.customexception;

public class MyException extends Exception {
	int detail;
	public MyException(int a) {
		this.detail = a;
	}
	
	public String toString() {
		return "MyException[" + detail + "]";
	}
}
