package com.factory.ocp.resolved;

public class ToyotoFactory implements IAutoMobileFactory {

	@Override
	public IAutoMobile make() {
		return new Toyoto();
	}

}
