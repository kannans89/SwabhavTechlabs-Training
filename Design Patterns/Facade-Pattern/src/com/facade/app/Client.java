package com.facade.app;

public class Client {

	public static void main(String[] args) {
		Shopkeeper shopKeeper = new Shopkeeper();
		shopKeeper.getBlackBerryDetails();
		shopKeeper.getSamsungDetails();
		shopKeeper.getIPhoneDetails();
	}

}
