package com.invoice.refractor.app;

public class Invoice {
	private int id, cost;
	private String name;
	private double GST, discount;
	
	public Invoice(int id, int cost, String name, double GST, double discount) {
		this.id = id;
		this.cost = cost;
		this.name = name;
		this.GST = GST;
		this.discount = discount;
	}
	
	public double calcTax() {
		return this.GST;
	}
	
	public double calcDiscount() {
		return this.discount;
	}
	
	public double cacTotalSalary() {
		return this.cost;
	}
}
