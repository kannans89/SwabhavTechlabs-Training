package com.abstractfactory.automobile.audi;

import com.abstractfactory.app.IAutoMobile;

public class AudiHatchBlack implements IAutoMobile{

	@Override
	public void start() {
		System.out.println("Audi Hatch black started");
		
	}

	@Override
	public void stop() {
		System.out.println("Audi Hatch black stopped");
		
	}

}