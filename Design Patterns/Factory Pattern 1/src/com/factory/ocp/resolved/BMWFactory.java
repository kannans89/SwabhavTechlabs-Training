package com.factory.ocp.resolved;

public class BMWFactory implements IAutoMobileFactory {

	@Override
	public BMW make() {
		return new BMW();
	}

}
