package com.swabhavtechlabs.customexception;

public class ExceptionTest {
	public static void compute(int a) throws MyException {
		System.out.println("Computed value "+a);
		if(a > 10) {
			throw new MyException(a);
		}
		System.out.println("Normal");
	}
	public static void main(String[] args) {
		try {
			compute(1);
			compute(29);
		} catch(MyException e) {
			System.out.println("Caught "+e);
		}
	}
}
