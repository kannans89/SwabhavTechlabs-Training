package com.abstractfactory.automobilefactory;

import com.abstractfactory.app.IAutoMobile;
import com.abstractfactory.automobile.audi.AudiHatchBlack;
import com.abstractfactory.automobile.audi.AudiSUV;
import com.abstractfactory.automobile.audi.AudiSedan;

public class AudiFactory implements IAutoMobileFactory{

	@Override
	public IAutoMobile makeHatchBlack() {
		return new AudiHatchBlack();
		
	}

	@Override
	public IAutoMobile makeSedan() {
		return new AudiSedan();
		
	}

	@Override
	public IAutoMobile makeSUV() {
		return new AudiSUV();
		
	}

}
