package com.abstractfactory.automobiles.bmw;

import com.abstractfactory.app.IAutoMobile;

public class BMWsuv implements IAutoMobile {

	@Override
	public void start() {
		System.out.println("BMW suv started");

	}

	@Override
	public void stop() {
		System.out.println("BMW suv stopped");

	}

}
