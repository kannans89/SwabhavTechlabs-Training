package com.swabhavtechlabs.ocp.refactor;

public class FixedDeposit {
	private String name;
	private double principle;
	private int years;
	private IRate rate;
	
	public FixedDeposit(String name, double principle, int years, IRate rate) {
		this.name = name;
		this.principle = principle;
		this.years = years;
		this.rate = rate;
	}
	
	public double calculateIntrest() {
		return (rate.getRate()/100)*this.principle*this.years;
	}
}
