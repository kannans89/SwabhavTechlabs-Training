package com.swabhavtechlabs.accountNew;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SavingTest {

	@Test
	void testWithDraw5000() {
		Saving saving = new Saving(101, 10000, "manu");
		assertTrue(saving.withDraw(5000) == true);
	}

	@Test
	void testWithDraw7000() {
		Saving saving = new Saving(101, 10000, "manu");
		assertTrue(saving.withDraw(7000) == false);
	}
}
