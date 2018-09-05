package com.swabhavtechlabs.lsp.test;

public class Rectangle implements Polygon{
	protected int width;
	protected int height;
	
	public Rectangle(int w, int h) {
		this.height = h;
		this.width = w;
	}
	@Override
	public double calculateArea() {
		return this.width*this.height;
	}
	public int getHeight() {
		return this.height;
	}
	public void setHeight(int i) {
		this.height = i;
		
	}
	
}
