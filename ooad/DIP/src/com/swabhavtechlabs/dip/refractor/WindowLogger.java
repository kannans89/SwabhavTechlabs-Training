package com.swabhavtechlabs.dip.refractor;

import java.util.Date;

public class WindowLogger implements ILogger{
	@Override
	public void log(Exception e) {
		System.out.println(new Date()+" "+"Window: "+e);
		
	}
}
