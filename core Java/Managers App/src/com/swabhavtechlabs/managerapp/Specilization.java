package com.swabhavtechlabs.managerapp;

public enum Specilization {
	INSURANCE, EQUITY, MUTUALFUND;
	
	public String toString() {
		switch(this) {
		case INSURANCE:
			return "Insurance";
			
		case EQUITY:
			return "Equity";
			
		case MUTUALFUND:
			return "Mutual fund";
		
		default:
			return "No mentioned specilization";
		}
	}
}
