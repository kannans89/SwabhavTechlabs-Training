package com.swabhavtechlabs.GuitarStoreApp;

public enum Type {
	ACOUSTIC, ELECTRIC;

	public String toString() {
		switch (this) {
		case ACOUSTIC:
			return "Accoustic";

		case ELECTRIC:
			return "Electric";
			
		default:
			return "Not found";
		}
	}
}
