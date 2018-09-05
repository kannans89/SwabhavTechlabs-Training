package com.facade.app;

public class Samsung implements IMobile {

	@Override
	public void price() {
		System.out.println("Samsung mobile Price is Rs "+1500);

	}

	@Override
	public void model() {
		System.out.println("Samsung mobile Model: galaxy");

	}

}
