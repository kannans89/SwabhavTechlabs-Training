package com.swabhavtechlabs.overridingexample;

public class ManTest {

	public static void main(String[] args) {
		case1();
	}

	private static void case1() {
		playground(new Boy());
		playground(new Infants());
		playground(new Kids());
		playground(new Man());
		
		playground(new Boy());
	}

	public static void playground(Man man) {
		man.play();
	}
}
