package com.techlabs.opencloseprincipal.violation.test;

import com.techlabs.opencloseprincipal.violation.FestivalType;
import com.techlabs.opencloseprincipal.violation.FixedDeposit;

public class FixedDepositTest {
	public static void main(String args[])
	{
		FixedDeposit fixedDeposit = new FixedDeposit("Shubham", 20.0, 4 , FestivalType.HOLI);
		
		System.out.println("Calculated Rate:\t"+ fixedDeposit.findRate());
		
		System.out.println("\nCalculated Interest:\t"+ fixedDeposit.calculateInterest());
	}

}
