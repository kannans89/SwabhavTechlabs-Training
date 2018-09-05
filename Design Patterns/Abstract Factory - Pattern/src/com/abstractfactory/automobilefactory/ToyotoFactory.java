package com.abstractfactory.automobilefactory;

import com.abstractfactory.app.IAutoMobile;
import com.abstractfactory.automobile.toyoto.ToyotoHatchBlack;
import com.abstractfactory.automobile.toyoto.Toyotosedan;
import com.abstractfactory.automobile.toyoto.Toyotosuv;

public class ToyotoFactory implements IAutoMobileFactory {

	@Override
	public IAutoMobile makeHatchBlack() {
		return new ToyotoHatchBlack();

	}

	@Override
	public IAutoMobile makeSedan() {
		return new Toyotosedan();

	}

	@Override
	public IAutoMobile makeSUV() {
		return new Toyotosuv();

	}

}
