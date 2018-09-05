package com.techlabs.opencloseprincipal.refactor;

import com.techlabs.opencloseprincipal.violation.FestivalType;

public class FixedDeposit {
	private String name;
	private double principal;
	private int year;
	private FestivalType festival;
	public FixedDeposit(String name, double principal, int year, FestivalType festival) {
		super();
		this.name = name;
		this.principal = principal;
		this.year = year;
		this.festival = festival;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrincipal() {
		return principal;
	}
	public void setPrincipal(double principal) {
		this.principal = principal;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public FestivalType getFestival() {
		return festival;
	}
	public void setFestival(FestivalType festival) {
		this.festival = festival;
	}
	
	
	public double calculateInterest()
	{
		CalculateRate calculateRate = new CalculateRate();
		return this.principal*this.year*0.01*(calculateRate.findRate(this));
	}


}
