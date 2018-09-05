package com.swabhavtechlabs.ocp.refactor;

public class Test {

	public static void main(String[] args) {
		IRate rate;
		rate = new Diwali();
		FixedDeposit diwaliFD = new FixedDeposit("abc", 15000, 2, rate);
		System.out.println("Rate of intrest Diwali "+diwaliFD.calculateIntrest());
		
		rate = new Holi();
		FixedDeposit HoliFD = new FixedDeposit("abc", 15000, 2, rate);
		System.out.println("Rate of intrest Holi "+HoliFD.calculateIntrest());
	}

}
