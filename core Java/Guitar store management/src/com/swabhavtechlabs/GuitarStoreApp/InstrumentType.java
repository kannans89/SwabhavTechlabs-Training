package com.swabhavtechlabs.GuitarStoreApp;

public enum InstrumentType {
	GUITAR, BANJO, BOBRO, FIDDLE, BASS, MANDOLIN;
	
	public String toString() {
		switch(this) {
		case GUITAR:
			return "Guitar";
		case BANJO:
			return "Banjo";
		case BOBRO:
			return "Bobro";
		case FIDDLE:
			return "Fiddle";
		case BASS:
			return "Bass";
		case MANDOLIN:
			return "Mandolin";
		default:
			return "Not specified";
		}
	}
}
