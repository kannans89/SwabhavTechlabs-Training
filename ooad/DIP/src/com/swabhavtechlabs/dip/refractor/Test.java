package com.swabhavtechlabs.dip.refractor;

public class Test {

	public static void main(String[] args) {
		TaxCaluclator calc = new TaxCaluclator();
		calc.caluclateTax(5, 0, new XMLLogger());
	}

}
