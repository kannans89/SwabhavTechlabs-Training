package com.swabhavtechlabs.dip.refractor;

import java.util.Date;

import com.swabhavtechlabs.dip.voilation.TXTLogger;
import com.swabhavtechlabs.dip.voilation.WindowLogger;
import com.swabhavtechlabs.dip.voilation.XMLLogger;

public class TaxCaluclator {
	public int caluclateTax(int amount, int rate, ILogger logger) {
		int tax = 0;
		try {
			tax = amount/rate;
		} catch(Exception e) {
			logger.log(e);
		}
		return 0;
	}
}
