package com.swabhavtechlabs.GuitarStoreApp;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GuitarTest {
	
	private static void initializeInventory(Inventory myInventory) {
		Map properties = new HashMap<>();
		properties.put("instrumentType", InstrumentType.GUITAR);
		properties.put("builder", Builder.COLLINGS);
		properties.put("model", "CJ");
		properties.put("type", Type.ACOUSTIC);
		properties.put("numStrings", 6);
		properties.put("topWood", Wood.INDIAN_ROSEWOOD);
		properties.put("backwood", Wood.SITKA);
		myInventory.addInstrument("111277", 3999.5, new InstrumentSpec(properties));
	}
	
	public static void main(String[] args) {
		Inventory myInventory = new Inventory();
		
		initializeInventory(myInventory);
		
		Map properties = new HashMap<>();
		properties.put("builder", Builder.COLLINGS);
		properties.put("backwood", Wood.SITKA);
		InstrumentSpec spec = new InstrumentSpec(properties);
		
		List matchingInstruments = myInventory.search(spec);
		if(!matchingInstruments.isEmpty()) {
			System.out.println("You might like these instruments");
			for(Iterator i = matchingInstruments.iterator(); i.hasNext();) {
				Instrument instrument = (Instrument)i.next();
				InstrumentSpec spec1 = instrument.getSPec();
				
				System.out.println("We have a"+spec1.getProperty("instrumentType") + "with the following properties");
				for(Iterator j = spec1.getProperties().keySet().iterator(); j.hasNext();) {
					String propertyName = (String)j.next();
					if(propertyName.equals("instrumentType"))
						continue;
					System.out.println(" "+propertyName+":"+spec1.getProperty(propertyName));
				}
				System.out.println(" you can have this "+spec.getProperty("instrumnetType")+"for $ ");
			}
		}else {
			System.out.println("nothing for you");
		}
	}
}
