package com.abstractfactory.automobile.audi;

import com.abstractfactory.app.IAutoMobile;

public class AudiSUV implements IAutoMobile {

	@Override
	public void start() {
		System.out.println("Audi SUV started");

	}

	@Override
	public void stop() {
		System.out.println("Audi SUV stopped");

	}

}
