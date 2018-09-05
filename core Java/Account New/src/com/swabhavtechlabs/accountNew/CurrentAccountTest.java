package com.swabhavtechlabs.accountNew;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CurrentAccountTest {

	@Test
	void testWithDraw5000() {
		CurrentAccount currentAccount = new CurrentAccount(101, 10000, "manoj");
		assertTrue(currentAccount.withDraw(5000) == true);
	}
	
	@Test
	void testWithDraw10000() {
		CurrentAccount currentAccount = new CurrentAccount(101, 10000, "manoj");
		assertEquals(true, currentAccount.withDraw(10000));
	}

	@Test
	void testWithDraw21000() {
		CurrentAccount currentAccount = new CurrentAccount(101, 10000, "manoj");
		assertTrue(false == currentAccount.withDraw(21000) );
	}
}
