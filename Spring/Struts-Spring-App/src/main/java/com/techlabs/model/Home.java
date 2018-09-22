package com.techlabs.model;

public class Home {
	private int flat_no;
	private String name;
	private String add;
	
	public Home() {}
	
	public Home(int no, String name, String add) {
		this.flat_no = no;
		this.name = name;
		this.add = add;
	}

	public int getFlat_no() {
		return flat_no;
	}

	public void setFlat_no(int flat_no) {
		this.flat_no = flat_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}
}
