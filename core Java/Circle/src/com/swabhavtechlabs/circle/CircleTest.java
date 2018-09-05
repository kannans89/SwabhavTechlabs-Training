package com.swabhavtechlabs.circle;

public class CircleTest {

	public static void printDetails(Circle circle) {
		System.out.println("Radius is "+circle.getRadius());
		System.out.println("Area is "+circle.caluclateArea());
		System.out.println("Border style is "+circle.getStyle());
	}
	
	public static void main(String[] args) {
		double radius = 1.5;
		BorderStyle borderStyle = BorderStyle.DASHED;
		
		Circle circle = new Circle(radius);
		
		circle.setRadius(radius);
		circle.setStyle(borderStyle);
		printDetails(circle);
		
//		BorderStyle[] styles = BorderStyle.values();
//		for(BorderStyle style : styles) {
//			System.out.println(style);
//		}

	}

}
