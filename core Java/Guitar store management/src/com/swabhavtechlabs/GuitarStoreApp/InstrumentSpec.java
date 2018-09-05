package com.swabhavtechlabs.GuitarStoreApp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InstrumentSpec {
	private Map properties;

	public InstrumentSpec(Map properties) {
		if(properties == null)
			this.properties = new HashMap<>();
		else
			this.properties = new HashMap<>(properties);
	}
	
	public Object getProperty(String propertyName) {
		return properties.get(propertyName);
	}
	
	public Map getProperties() {
		return properties;
	}
		
	public boolean matches(InstrumentSpec spec) {
		for(Iterator i = spec.getProperties().keySet().iterator(); i.hasNext();) {
			String propertyName = (String)i.next();
			if(!properties.get(propertyName).equals(spec.getProperty(propertyName))) {
				return false;
			}
		}
		return true;
	}
}
