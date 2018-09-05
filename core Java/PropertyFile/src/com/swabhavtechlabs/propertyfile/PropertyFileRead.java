package com.swabhavtechlabs.propertyfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileRead {
	Properties prop = new Properties();
	FileInputStream fin = null;
	
	public void readPropertyFile() {
		try (FileInputStream fin = new FileInputStream("config.properties")){
			prop.load(fin);
			
			System.out.println(prop.getProperty("username"));
			System.out.println(prop.getProperty("password"));
		} catch(IOException io) {
			System.out.println(io);
		}
		
	}
}
