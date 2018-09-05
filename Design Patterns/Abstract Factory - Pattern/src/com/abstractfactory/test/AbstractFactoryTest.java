package com.abstractfactory.test;

import com.abstractfactory.app.IAutoMobile;
import com.abstractfactory.automobilefactory.AudiFactory;
import com.abstractfactory.automobilefactory.IAutoMobileFactory;

public class AbstractFactoryTest {

	public static void main(String[] args) {
		IAutoMobileFactory autoMobileFactory = new AudiFactory();
		IAutoMobile hatchBlack = autoMobileFactory.makeHatchBlack();
		hatchBlack.start();
		hatchBlack.stop();

	}

}
