package com.swabhavtechlabs.shoppingCart.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.swabhavtechlabs.shoppingCart.LineItem;
import com.swabhavtechlabs.shoppingCart.Product;

class LineItemTest {

	@Test
	void calculateTotalPrice() {
		Product product = new Product("Watch", "w101", 999, 10);
		LineItem lineItem = new LineItem(5, "w1015", product);
		System.out.println(lineItem.totalCost());
		assertEquals(4495.5, lineItem.totalCost());
	}

}
