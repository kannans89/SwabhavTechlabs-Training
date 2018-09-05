package com.decorator1.app;

public class FillColorDecorator extends ShapeDecorator {

	public FillColorDecorator(IShape shape) {
		super(shape);
	}
	
	public void draw() {
		super.draw();
		fillColor();
	}
	public void fillColor() {
		System.out.println("Filling color");
	}

}
