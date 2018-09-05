package com.swabhavtechlabs.rtoapp;

public class RTO {
	private String code;
	private String state;
	
	public RTO(String code, String state) {
		this.code = code;
		this.state = state;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
