package com.abstractfactory.automobile.toyoto;

import com.abstractfactory.app.IAutoMobile;

public class Toyotosedan implements IAutoMobile {

	@Override
	public void start() {
		System.out.println("Toyoto sedan started");

	}

	@Override
	public void stop() {
		System.out.println("Toyoto sedan stopped");
	}

}
