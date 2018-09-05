package com.decorator.app;

public class FoodDecorator implements Food {

	Food newFood;
	
	public FoodDecorator(Food food) {
		this.newFood = food;
	}
	@Override
	public void prepareFood() {
		this.newFood.prepareFood();
	}
	@Override
	public double foodPrice() {
		return this.newFood.foodPrice();
	}
}
