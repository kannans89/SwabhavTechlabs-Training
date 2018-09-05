package com.techlabs.opencloseprincipal.violation;

public enum FestivalType {
     HOLI,NEWYEAR,NORMAL;
	
	public String toString()
	{
		switch(this){
		case HOLI:
			return "holi";
		case NEWYEAR:
			return "newyear";
		case NORMAL:
			return "normal";
		default:
			return "not present";
		}
	}
}
