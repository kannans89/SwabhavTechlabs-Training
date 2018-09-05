package com.swabhavtechlabs.dip.refractor;

import java.util.Date;

public class TXTLogger implements ILogger{
	@Override
	public void log(Exception e) {
		System.out.println(new Date()+" "+"TXT: "+e);
	}
}
