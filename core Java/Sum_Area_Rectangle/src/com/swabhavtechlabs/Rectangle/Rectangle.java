package com.swabhavtechlabs.Rectangle;

public class Rectangle {
	private double height, width;
	private String borderColor;
	
//	public Rectangle(double height, double width) {
//		this.height = height;
//		this.width = width;
//	}
	
	public double calculateArea() {
		 return height*width;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public String getColor() {
		return this.borderColor;
	}
	
	public void setHeight(double height) {
		this.height = checkParameter(height);
	}
	
	public void setWidth(double width) {
		this.width = checkParameter(width);
	}
	
	public void setColor(String color) {
		this.borderColor = checkColor(color);
	}
	
	public String checkColor(String color) {
		if(!color.equalsIgnoreCase("red") && !color.equalsIgnoreCase("blue") && !color.equalsIgnoreCase("green"))
			return "Red";
		else 
			return color;
	}
	
	public double checkParameter(double parameter) {
		if(parameter < 1) {
			return 1;
		} else if(parameter > 100) {
			return 100;
		} else {
			return parameter;
		}
	}

	
}
