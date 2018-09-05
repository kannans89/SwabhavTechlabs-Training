package com.factory.ocp.resolved;

public class FactoryTest {

	public static void main(String[] args) {
		IAutoMobileFactory autoMobileFactory = new BMWFactory();
		IAutoMobile autoMObile = autoMobileFactory.make();
		autoMObile.start();
		autoMObile.start();

		System.out.println();
		autoMobileFactory = new AudiFactory();
		autoMObile = new Audi();
		autoMObile.start();
		autoMObile.stop();

		System.out.println();
		autoMobileFactory = new ToyotoFactory();
		autoMObile = new Toyoto();
		autoMObile.start();
		autoMObile.stop();
	}

}
