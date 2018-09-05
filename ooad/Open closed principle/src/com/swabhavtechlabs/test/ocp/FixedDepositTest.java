package com.swabhavtechlabs.test.ocp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.swabhavtechlabs.ocp.refactor.Diwali;
import com.swabhavtechlabs.ocp.refactor.FixedDeposit;
import com.swabhavtechlabs.ocp.refactor.IRate;

class FixedDepositTest {
	IRate rate;
	@Test
	void caclulateIntrestTest() {
		rate = new Diwali();
		FixedDeposit fd = new FixedDeposit("manoj", 15000.0, 2, rate);
		assertEquals(2700, fd.calculateIntrest());
	}

}
