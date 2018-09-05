package com.swabhavtechlabs.propertyfile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileWrite {
	Properties prop = new Properties();
	FileOutputStream fout = null;

	public void writeToPropertyFile() {
		try {
			fout = new FileOutputStream("config.properties");

			prop.setProperty("username", "test123");
			prop.setProperty("password", "123");

			prop.store(fout, null);
		} catch (IOException io) {
			System.out.println(io);
		} finally {
			try {
				if (fout != null) {
					fout.close();
				}
			} catch (IOException io) {
				System.out.println(io);
			}
		}
	}
}
