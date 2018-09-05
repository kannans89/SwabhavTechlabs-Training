package com.abstractfactory.automobile.toyoto;

import com.abstractfactory.app.IAutoMobile;

public class Toyotosuv implements IAutoMobile {

	@Override
	public void start() {
		System.out.println("Toyoto suv started");
	}

	@Override
	public void stop() {
		System.out.println("Toyoto suv stopped");
	}

}
