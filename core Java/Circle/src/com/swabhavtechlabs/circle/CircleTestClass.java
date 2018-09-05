package com.swabhavtechlabs.circle;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircleTestClass {

	@Test
	public void testCaluclateArea() {
		Circle c = new Circle(1);
		double value = c.caluclateArea();
		assertTrue(3.142 == value);
	}
}
