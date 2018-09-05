package com.abstractfactory.automobiles.bmw;

import com.abstractfactory.app.IAutoMobile;

public class BMWHatchBlack implements IAutoMobile {

	@Override
	public void start() {
		System.out.println("BMW hatch black started");

	}

	@Override
	public void stop() {
		System.out.println("BMW hatch black stopped");

	}

}
