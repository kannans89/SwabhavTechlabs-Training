package com.swabhavtechlabs.lsp.test;

public class Square implements Polygon{
	protected double side;
	
	public Square(int side) {
		this.side = side;
	}
	@Override
	public double calculateArea() {
		return this.side*this.side;
	}

}
