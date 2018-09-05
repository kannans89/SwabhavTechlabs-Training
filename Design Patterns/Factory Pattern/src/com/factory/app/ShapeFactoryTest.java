package com.factory.app;

public class ShapeFactoryTest {

	public static void main(String[] args) {
		ShapeFactory factory = new ShapeFactory();
		factory.getShape("square").draw();
		factory.getShape("rectangle").draw();
		factory.getShape("circle").draw();
	}
}
