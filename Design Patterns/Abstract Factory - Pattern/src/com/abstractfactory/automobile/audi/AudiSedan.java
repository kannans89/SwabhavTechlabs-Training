package com.abstractfactory.automobile.audi;

import com.abstractfactory.app.IAutoMobile;
import com.abstractfactory.automobilefactory.IAutoMobileFactory;

public class AudiSedan implements IAutoMobile {

	@Override
	public void start() {
		System.out.println("Audi sedan started");

	}

	@Override
	public void stop() {
		System.out.println("Audi sedan stopped");

	}
}
