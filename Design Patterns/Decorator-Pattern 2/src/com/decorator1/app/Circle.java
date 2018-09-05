package com.decorator1.app;

public class Circle implements IShape{

	@Override
	public void draw() {
		System.out.println("Drawing circle");
	}
}
