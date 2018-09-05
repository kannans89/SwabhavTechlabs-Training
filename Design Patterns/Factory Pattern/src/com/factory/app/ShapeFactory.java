package com.factory.app;

public class ShapeFactory {
	public Ishape getShape(String type) {
		if("square".equalsIgnoreCase(type))
			return new Square();
		else if("rectangle".equalsIgnoreCase(type))
			return new Rectangle();
		else
			return new Circle();
	}
}
