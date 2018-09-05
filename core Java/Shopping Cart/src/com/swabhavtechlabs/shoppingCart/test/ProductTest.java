package com.swabhavtechlabs.shoppingCart.test;

import com.swabhavtechlabs.shoppingCart.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductTest {

	@Test
	void calculatePriceTest() {
		Product product = new Product("Watch", "w101", 999, 10);
		assertEquals(899.1 ,  product.calculatePrice());
	}

}
