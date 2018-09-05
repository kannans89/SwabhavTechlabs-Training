package com.swabhavtechlabs.dip.refractor;

import java.util.Date;

public class XMLLogger implements ILogger{

	@Override
	public void log(Exception e) {
		System.out.println(new Date()+" "+"XML: "+e);
		
	}

}
