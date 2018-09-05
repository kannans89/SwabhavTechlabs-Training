package com.invoice.refractor.test;

import com.invoice.refractor.app.*;
public class InvoiceTest {

	public static void main(String[] args) {
		Invoice invoice = new Invoice(25, 6333, "abc", 18, 15);
		invoice.cacTotalSalary();
		printDetails details = new printDetails();
		details.printDetails();
	}

}
