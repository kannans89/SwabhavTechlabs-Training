package com.decorator1.app;

public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(IShape shape) {
		super(shape);
	}
	
	public void draw() {
		super.draw();
		setRedBorder();
	}
	
	public void setRedBorder() {
		System.out.println("Setting red border");
	}
}
