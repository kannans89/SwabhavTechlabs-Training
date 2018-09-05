package com.abstractfactory.automobilefactory;

import com.abstractfactory.app.IAutoMobile;
import com.abstractfactory.automobiles.bmw.BMWHatchBlack;
import com.abstractfactory.automobiles.bmw.BMWSedan;
import com.abstractfactory.automobiles.bmw.BMWsuv;

public class BMWAudifactory implements IAutoMobileFactory {

	@Override
	public IAutoMobile makeHatchBlack() {
		return new BMWHatchBlack();

	}

	@Override
	public IAutoMobile makeSedan() {
		return new BMWSedan();

	}

	@Override
	public IAutoMobile makeSUV() {
		return new BMWsuv();

	}

}
