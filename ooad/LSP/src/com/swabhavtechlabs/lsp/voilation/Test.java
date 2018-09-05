package com.swabhavtechlabs.lsp.voilation;

public class Test {

	public static void shouldNotMoveWidthWhenHeightIsMoved(Rectangle rect) {
		int beforeWidth = rect.width;
		rect.setHeight(rect.getHeight()+4);
		int afterWidth = rect.width;
		System.out.println("Before "+beforeWidth);
		System.out.println("After "+afterWidth);
	}
	
	public static void main(String[] args) {
		Rectangle rect = new Rectangle(5, 4);
		Rectangle square = new Square(5);
		System.out.println("Rectangle");
		shouldNotMoveWidthWhenHeightIsMoved(rect);
		System.out.println();
		System.out.println("Square");
		shouldNotMoveWidthWhenHeightIsMoved(square);
	}

}
