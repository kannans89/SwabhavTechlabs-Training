package com.swabhavtechlabs.GuitarStoreApp;

public enum Wood {
	INDIAN_ROSEWOOD, BRAZILIAN_ROSEWOOD, MAHAGONY, MAPLE, COCOBOLO, CEDAR, ADRIONDACK, ALDER, SITKA;

	public String toString() {
		switch (this) {
		case INDIAN_ROSEWOOD:
			return "Indian Rosewood";
		case BRAZILIAN_ROSEWOOD:
			return "Brazilian Rosewood";
		case ADRIONDACK:
			return "Adriondack";
		case MAPLE:
			return "Maple";
		case COCOBOLO:
			return "Cocobolo";
		case CEDAR:
			return "Cedar";
		case ALDER:
			return "Alder";
		case SITKA:
			return "Sitka";
		case MAHAGONY:
			return "Mahagony";
		default: return "Not found";
		}
	}
}
