package com.swabhavtechlabs.dip.voilation;

import java.util.Date;

public class TaxCaluclator {
	private LogType type;
	
	public TaxCaluclator(LogType type) {
		this.type = type;
	}
	
	public int caluclateTax(int amount, int rate) {
		int tax = 0;
		
		try {
			tax = amount/rate;
		} catch(Exception e) {
			callLogger(e);
		}
		return tax;
	}
	
	private void callLogger(Exception e) {
		if(this.type == LogType.TXT) {
			new TXTLogger().load(new Date(), "Txt: "+e.getMessage());
		} else if(this.type == LogType.XML)
			new XMLLogger().load(new Date(), "XML: "+e.getMessage());
		else
			new WindowLogger().load(new Date(), "WINDOW: "+e.getMessage());
	}
}
