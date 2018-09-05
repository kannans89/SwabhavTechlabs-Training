package com.decorator.app;

public class NonVegFood extends FoodDecorator {

	double price = 100;
	public NonVegFood(Food food) {
		super(food);
	}
	@Override
	public void prepareFood() {
		super.prepareFood();
		System.out.println("Preparing NonVegFood");
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double foodPrice() {
		return super.foodPrice()+this.price;
	}
}
