package com.swabhavtechlabs.propertyfile;

public class PropertyFileTest {

	public static void main(String[] args) {
		PropertyFileWrite write = new PropertyFileWrite();
		write.writeToPropertyFile();

		PropertyFileRead read = new PropertyFileRead();
		read.readPropertyFile();
	}

}
