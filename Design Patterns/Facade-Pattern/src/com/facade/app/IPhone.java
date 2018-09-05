package com.facade.app;

public class IPhone implements IMobile {

	@Override
	public void price() {
		System.out.println("Iphone Price is Rs "+2500);

	}

	@Override
	public void model() {
		System.out.println("IPhone Model: 8+");

	}

}
