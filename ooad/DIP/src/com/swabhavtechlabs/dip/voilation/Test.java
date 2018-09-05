package com.swabhavtechlabs.dip.voilation;

public class Test {

	public static void main(String[] args) {
		TaxCaluclator calc = new TaxCaluclator(LogType.XML);
		int tax = calc.caluclateTax(5, 0);
		System.out.println("Tax is "+tax);
	}

}
