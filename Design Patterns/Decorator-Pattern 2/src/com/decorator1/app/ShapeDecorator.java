package com.decorator1.app;

public class ShapeDecorator implements IShape {

	IShape newShape;
	public ShapeDecorator(IShape shape) {
		this.newShape = shape;
	}
	@Override
	public void draw() {
		this.newShape.draw();
	}

}
