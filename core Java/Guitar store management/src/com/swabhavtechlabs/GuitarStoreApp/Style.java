package com.swabhavtechlabs.GuitarStoreApp;

public enum Style {
	A, F;
	
	public String toString() {
		switch(this) {
		case A:
			return "Style A";
			
		case F:
			return "Style F";
		}
		return null;
	}
}
