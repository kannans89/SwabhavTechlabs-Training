package com.swabhavtechlabs.lsp.test;

import com.swabhavtechlabs.lsp.voilation.Rectangle;
import com.swabhavtechlabs.lsp.voilation.Square;
public class Test {

	public static void shouldNotMoveWidthWhenHeightIsMoved(com.swabhavtechlabs.lsp.test.Rectangle rect) {
		int beforeWidth = rect.width;
		rect.setHeight(rect.getHeight()+4);
		int afterWidth = rect.width;
		System.out.println("Before "+beforeWidth);
		System.out.println("After "+afterWidth);
	}
	
	public static void main(String[] args) {
		com.swabhavtechlabs.lsp.test.Rectangle rect = new com.swabhavtechlabs.lsp.test.Rectangle(5,4);
		com.swabhavtechlabs.lsp.test.Square square = new com.swabhavtechlabs.lsp.test.Square(5);
		System.out.println("Rectangle");
		shouldNotMoveWidthWhenHeightIsMoved(rect);
		System.out.println();
		System.out.println("Square");
		//shouldNotMoveWidthWhenHeightIsMoved(square);
	}
}
