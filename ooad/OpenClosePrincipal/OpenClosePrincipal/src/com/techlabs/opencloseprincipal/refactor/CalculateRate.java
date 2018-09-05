package com.techlabs.opencloseprincipal.refactor;

public class CalculateRate {
	
	public double findRate(FixedDeposit fixedDeposit)
	{
		if(fixedDeposit.getFestival().toString().equals("holi"))
		{
		  return 8.0;
		}else if(fixedDeposit.getFestival().toString().equals("newyear"))
		{
			return 9.0;
		}else if(fixedDeposit.getFestival().toString().equals("normal")){
			return 7.0;
		}else
			{
			return 0.0;
			}
	}
}
