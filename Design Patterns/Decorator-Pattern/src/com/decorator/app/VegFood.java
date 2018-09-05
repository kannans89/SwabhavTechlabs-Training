package com.decorator.app;

public class VegFood implements Food{

	double price = 25;
	@Override
	public void prepareFood() {
		System.out.println("Preparing veg food");
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public double foodPrice() {
		return this.price;
	}
}
