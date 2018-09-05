package com.factory.ocp.resolved;

public class AudiFactory implements IAutoMobileFactory {

	@Override
	public IAutoMobile make() {
		return new Audi();
	}

}
