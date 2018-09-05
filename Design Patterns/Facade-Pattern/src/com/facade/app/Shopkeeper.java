package com.facade.app;

public class Shopkeeper {
	Samsung samsung;
	IPhone iphone;
	BlackBerry blackberry;
	
	public Shopkeeper() {
		this.samsung = new Samsung();
		this.iphone = new IPhone();
		this.blackberry = new BlackBerry();
	}
	
	public void getSamsungDetails() {
		samsung.price();
		samsung.model();
	}
	
	public void getIPhoneDetails() {
		iphone.price();
		iphone.model();
	}
	
	public void getBlackBerryDetails() {
		blackberry.price();
		blackberry.model();
	}
}
