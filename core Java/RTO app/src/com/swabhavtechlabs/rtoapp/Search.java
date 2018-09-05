package com.swabhavtechlabs.rtoapp;

import java.util.List;

public class Search {
	public int search(RTO rto, char ch) {
		for(int i=0; i<rto.getState().length(); i++) {
			if(rto.getState().charAt(i) == ch) {
				return 1;
			}
		}
		return 0;
	}
}
