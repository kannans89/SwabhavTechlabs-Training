package com.decorator.app;

public class ChineseFood extends FoodDecorator {

	double price = 50;
	public ChineseFood(Food food) {
		super(food);
	}
	
	public void prepareFood() {
		super.prepareFood();
		System.out.println("Prepareing chinese food");
	}
	
	public double foodPrice() {
		return super.foodPrice() + this.price;
	}
}
