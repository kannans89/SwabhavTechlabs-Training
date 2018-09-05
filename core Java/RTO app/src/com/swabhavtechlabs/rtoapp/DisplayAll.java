package com.swabhavtechlabs.rtoapp;

import java.util.List;

public class DisplayAll {
	public void displayAll(List<RTO> rtos) {
		for(RTO rto: rtos) {
			System.out.println(rto.getCode() + "\t"+ rto.getState());
		}
	}
}
