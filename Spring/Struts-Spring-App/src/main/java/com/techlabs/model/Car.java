package com.techlabs.model;

public class Car {
	private int VIN;
	private String model;
	private double price;
	
	public Car() {}
	
	public Car(int vin, String model, double price) {
		this.VIN = vin;
		this.model = model;
		this.price = price;
	}

	public int getVIN() {
		return VIN;
	}

	public void setVIN(int vIN) {
		VIN = vIN;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
