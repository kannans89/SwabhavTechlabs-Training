package com.decorator1.app;

public class Client {

	public static void main(String[] args) {
		IShape shape = new Circle();
		//shape.draw();
		
		IShape redCircle = new RedShapeDecorator(shape);
		//redCircle.draw();
		
		IShape filledCircle = new FillColorDecorator(new RedShapeDecorator(shape));
		filledCircle.draw();
	}

}
