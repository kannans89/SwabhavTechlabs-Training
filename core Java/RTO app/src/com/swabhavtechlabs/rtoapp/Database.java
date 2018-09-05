package com.swabhavtechlabs.rtoapp;

import java.util.ArrayList;
import java.util.List;import java.awt.FocusTraversalPolicy;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class Database {
	Properties properties = new Properties();
	
	public void writeToPropertyFile(List<RTO> rto) {
		try(FileOutputStream fout = new FileOutputStream("config.properties")){
			for(int i=0; i<rto.size(); i++) {
				properties.setProperty(rto.get(i).getCode(), rto.get(i).getState());
			}
			properties.store(fout, null);
		}catch(IOException e) {
			System.out.println(e);
		}
	}
		public List<RTO> readFromPropertiesFile() {
		List<RTO> rtos = new ArrayList<RTO>();
		try (FileInputStream fin = new FileInputStream("config.properties")){
			properties.load(fin);
			
			Set<String> keys = properties.stringPropertyNames();
			for(String key: keys) {
				rtos.add(new RTO(key, properties.getProperty(key)));
			}
		} catch(IOException io) {
			System.out.println(io);
		}
		return rtos;
	}
}
