package com.swabhavtechlabs.GuitarStoreApp;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
	private List<Instrument> inventory = null;
	
	public Inventory() {
		inventory = new LinkedList<>();
	}
	
	public void addInstrument(String serialNumber, double price, InstrumentSpec spec) {
		Instrument instrument = null;
		instrument  = new Instrument(serialNumber, price, spec);
		inventory.add(instrument);
		//Collections.sort(inventory);
	}
	
	public Instrument getInstrument(String serialNumber) {
		
		for(Instrument instrument: inventory) {
			if(instrument.getSerialNUmber().equals(serialNumber))
				return instrument;
		}
		return null;
	}

	public List<Instrument> search(InstrumentSpec instrument) {
		List<Instrument> matchingInstruments = new LinkedList<>();
		
		for(Instrument ins: inventory) {
			Instrument matchInstrument = (Instrument) ins;
			if(matchInstrument.getSPec().matches(instrument)) {
				
				matchingInstruments.add(matchInstrument);
			}
			
		}
		return matchingInstruments;
	}
}
