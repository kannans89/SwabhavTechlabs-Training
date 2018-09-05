package com.factory.ocp.resolved;

public class Audi implements IAutoMobile {

	@Override
	public void start() {
		System.out.println("Audi Started");

	}

	@Override
	public void stop() {
		System.out.println("Audi Stopped");

	}

}
