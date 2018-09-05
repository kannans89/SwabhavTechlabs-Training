package com.decorator.app;

public class Client {

	public static void main(String[] args) {
		Food vegFood = new VegFood();
		//Food nonVegFood = new NonVegFood(vegFood);
		//nonVegFood.prepareFood();
		//System.out.println(nonVegFood.foodPrice());

		System.out.println();

		Food chineseFood = new ChineseFood(new NonVegFood(new VegFood()));
		chineseFood.prepareFood();
		System.out.println(chineseFood.foodPrice());
	}

}
