package com.swabhavtechlabs.Rectangle;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class RectangleTest {
	
	public static void printDetails(Rectangle rectangle) {
		System.out.println("Height of the rectangle is "+rectangle.getHeight());
		System.out.println("Width of the rectangle is "+rectangle.getWidth());
		System.out.println("Area of the rectangle is "+rectangle.calculateArea());
		System.out.println();
		System.out.println();
	}
	
	public static void main(String[] args) {
		//Rectangle rectangles[] = new Rectangle[3];
		double sumOfArea = 0.0;
//		for(int i=0; i<rectangles.length; i++) {
//			rectangles[i] = new Rectangle();
//			rectangles[i].setHeight((i+1)*5);
//			rectangles[i].setWidth((i+1)*10);
//			printDetails(rectangles[i]);
//			sumOfArea = sumOfArea + rectangles[i].calculateArea();
//		}
		
		Rectangle rect1 = new Rectangle(5, 4);
		Rectangle rect2 = new Rectangle(5,4);
		Rectangle rect3 = rect1;
		if(rect1.hashCode() == rect3.hashCode()) {
			if(rect1.equals(rect3)) {
				//System.out.println("Equals");
			} else {
				//System.out.println("Not equal");
			}
		} else {
			//System.out.println("Hashcodes are not equal");
		}
		//System.out.println("Sum of areas of rectangles is "+sumOfArea);
		
//		if(rect1 == rect2) {
//			System.out.println("Equals");
//		}else {
//			System.out.println("Not equal");
//		}
		
		Class<Rectangle> RectangleClass = Rectangle.class;
		
		Method[] methods = RectangleClass.getMethods();
		System.out.println("Diffrent getters and setters methods of Rectangle class are");
		for(Method method: methods) {
			if(method.getName().startsWith("get") || method.getName().startsWith("set"))
				System.out.println("Method = "+method.getName());
		}
		
		Field[] fields = RectangleClass.getFields();
		System.out.println("Diffrent Fields of Rectangle class are");
		for(Field field: fields) {
			System.out.println("Field = "+field.getName());
		}
		
		Constructor<Rectangle>[] constructor = (Constructor<Rectangle>[]) RectangleClass.getDeclaredConstructors();
		System.out.println("Diffrent Constructor of Rectangle class are");
		for(Constructor<Rectangle> con: constructor) {
			System.out.println("Constructor = "+con.getParameterCount());
		}
	}

}
