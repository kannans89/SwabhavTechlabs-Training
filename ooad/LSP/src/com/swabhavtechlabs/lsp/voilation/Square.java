package com.swabhavtechlabs.lsp.voilation;

public class Square extends Rectangle{
	
	public Square(int side) {
		super(side, side);
	}

	public void setHeight(int height) {
		this.height = height;
		this.width = height;
	}
	
	public void setWidth(int width) {
		this.height = width;
		this.width = width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getWidth() {
		return this.width;
	}
}
