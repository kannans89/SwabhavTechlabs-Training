package com.abstractfactory.automobiles.bmw;

import com.abstractfactory.app.IAutoMobile;

public class BMWSedan implements IAutoMobile {

	@Override
	public void start() {
		System.out.println("BMW sedan started");
	}

	@Override
	public void stop() {
		System.out.println("BMW sedan stopped");
	}

}
