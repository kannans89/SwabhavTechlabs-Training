package com.swabhavtechlabs.ocp.voilation;

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

	public double findRate() {
		if (festival.toString().equals("holi")) {
			festival = festival.HOLI;
			return festival.getRate();
		} else if (festival.toString().equals("newyear")) {
			festival = festival.NEWYEAR;
			return festival.getRate();
		} else if (festival.toString().equals("normal")) {
			festival = festival.NORMAL;
			return festival.getRate();
		} else {
			return 0;
		}
	}

	public double calculateInterest() {
		return this.principal * this.year * 0.01 * this.findRate();
	}
}
