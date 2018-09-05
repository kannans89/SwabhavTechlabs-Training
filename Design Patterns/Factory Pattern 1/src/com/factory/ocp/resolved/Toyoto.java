package com.factory.ocp.resolved;

public class Toyoto implements IAutoMobile {

	@Override
	public void start() {
		System.out.println("Toyota Started");

	}

	@Override
	public void stop() {
		System.out.println("Toyota Stopped");

	}

}
