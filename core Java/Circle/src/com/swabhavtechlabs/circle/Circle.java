package com.swabhavtechlabs.circle;

public class Circle {
	private double radius;
	BorderStyle borderStyle;
	
	Circle(double radius) {
		this.radius = radius;
	}
	
	public double caluclateArea() {
		return 3.142*(this.radius*this.radius);
	}
	
	public void setStyle(BorderStyle borderStyle) {
		this.borderStyle = borderStyle;
	}
	
	public BorderStyle getStyle() {
		return this.borderStyle;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
}
