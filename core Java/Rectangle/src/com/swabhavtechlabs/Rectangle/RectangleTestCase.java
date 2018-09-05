package com.swabhavtechlabs.Rectangle;

import static org.junit.Assert.*;

import org.junit.Test;

public class RectangleTestCase {

	@Test
	public void checkArea() {
		Rectangle rect = new Rectangle(5, 4);
		double area = rect.calculateArea();
		assertTrue(20 == area);
	}

	@Test
	public void checkParameter() {
		Rectangle rect = new Rectangle(5, 4);
		double v = rect.checkParameter(20);
		assertTrue(20 == v);
	}
	
	@Test
	public void checkColor() {
		Rectangle rect = new Rectangle(5, 4);
		String str = rect.checkColor("blue");
		assertTrue(str == "blue");
	}
	
	@Test
	public void checkHeightBetween1_To_100() {
		Rectangle rect = new Rectangle(5, 4);
		rect.setHeight(6);
		assertTrue(rect.getHeight() >1 && rect.getHeight() <100);
	}
	
	@Test
	public void checkAreaGreaterThan100() {
		Rectangle rect = new Rectangle(50, 4);
		double area = rect.calculateArea();
		assertTrue(area < 1000);
	}
}
