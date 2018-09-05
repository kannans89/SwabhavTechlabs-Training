package com.swabhavtechlabs.accountNew;

public class CurrentAccount extends Account {
	private double OVERDRAFT_LIMIT = 10000;

	public CurrentAccount(int ac, double balance, String name) {
		super(ac, balance, name);
	}

	@Override
	public boolean withDraw(int amount) {
		if (this.getBalance() == 0) {
			if (amount <= OVERDRAFT_LIMIT) {
				this.OVERDRAFT_LIMIT -= amount;
				return true;
			}
		} else {
			if (this.getBalance() >= amount) {
				this.setBalance(this.getBalance() - amount);
				return true;
			} else if (this.getBalance() < amount) {
				double temp = amount - this.getBalance();
				this.setBalance(0);
				if (this.OVERDRAFT_LIMIT > temp) {
					this.OVERDRAFT_LIMIT -= temp;
					return true;
				} else
					return false;
			}
		}
		return false;
	}

	public double getOVERDRAFT_LIMIT() {
		return this.OVERDRAFT_LIMIT;
	}

	public void setOVERDRAFT_LIMIT(double oVERDRAFT_LIMIT) {
		this.OVERDRAFT_LIMIT = oVERDRAFT_LIMIT;
	}

}
