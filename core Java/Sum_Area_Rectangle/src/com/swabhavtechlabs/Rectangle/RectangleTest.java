package com.swabhavtechlabs.Rectangle;

import java.util.Scanner;

public class RectangleTest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double height, width;
		String color;
		
		System.out.println("Enter height and width of Rectangle");
		height = sc.nextDouble();
		width = sc.nextDouble();
		
		System.out.println("Enter the border color of a rectangle");
		color = sc.next();
		
		Rectangle rectangle1 = new Rectangle();
		
		rectangle1.setHeight(height);
		rectangle1.setWidth(width);
		rectangle1.setColor(color);
		double area = rectangle1.calculateArea();
		
		System.out.println("Height of the rectangle is "+rectangle1.getHeight());
		System.out.println("Width of the rectangle is "+rectangle1.getWidth());
		System.out.println("Area of the rectangle is "+area);
		System.out.println("Border color of the rectangle is "+rectangle1.getColor());
	}

}
