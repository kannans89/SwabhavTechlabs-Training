package com.swabhavtechlabs.ocp.voilation;

public enum FestivalType {
HOLI,NEWYEAR,NORMAL;
	
	public int getRate()
	{
		switch(this){
		case HOLI:
			return 8;
		case NEWYEAR:
			return 9;
		case NORMAL:
			return 10;
		default:
			return 0;
		}
}
}