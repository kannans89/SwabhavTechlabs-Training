package com.abstractfactory.automobilefactory;

import com.abstractfactory.app.IAutoMobile;

public interface IAutoMobileFactory {
	public IAutoMobile makeHatchBlack();
	public IAutoMobile makeSedan();
	public IAutoMobile makeSUV();
}
