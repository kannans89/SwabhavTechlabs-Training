package com.swabhavtechlabs.accountNew;

public class Saving extends Account {
	private static double LIMIT = 4000;
	
	public Saving(int ac, double balance, String name) {
		super(ac, balance, name);
	}

	@Override
	public boolean withDraw(int amount) {
		double amountRemainAfterWithDraw = this.getBalance() - amount;
		if(amountRemainAfterWithDraw > LIMIT) {
			this.setBalance(amountRemainAfterWithDraw);
			return true;
		}
		return false;
	}

	public static double getLIMIT() {
		return LIMIT;
	}

	public static void setLIMIT(double lIMIT) {
		LIMIT = lIMIT;
	}

}
