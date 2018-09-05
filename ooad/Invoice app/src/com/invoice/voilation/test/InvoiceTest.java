package com.invoice.voilation.test;

import com.invoice.voilation.app.Invoice;

public class InvoiceTest {

	public static void main(String[] args) {
		Invoice invoice = new Invoice(1, 1500, "abc", 20, 10);
		invoice.cacTotalSalary();
		invoice.calcTax();
		invoice.calcDiscount();
	}

}
