package com.facade.app;

public class BlackBerry implements IMobile {

	@Override
	public void price() {
		System.out.println("Iphone Price is Rs "+20000);

	}

	@Override
	public void model() {
		System.out.println("IPhone Model: cbz");

	}

}
