package com.swabhavtechlabs.GuitarStoreApp;

	public class Instrument {
	private String serialNUmber;
	private double price;
	private InstrumentSpec spec;
	
	public Instrument(String serialNumber, double price, InstrumentSpec spec) {
		this.serialNUmber = serialNumber;
		this.price = price;
		this.spec = spec;
	}
	
	public InstrumentSpec getSPec() {
		return spec;
	}

	public Object getSerialNUmber() {
		// TODO Auto-generated method stub
		return null;
	}
}
