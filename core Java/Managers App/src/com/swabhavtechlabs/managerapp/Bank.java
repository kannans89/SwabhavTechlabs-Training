package com.swabhavtechlabs.managerapp;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	Database db = new Database();
	private List<Manager> managers = new ArrayList<>();
	
	public Bank() {
		this.managers = db.retrieve();
	}
	
	public void addToManagerList(Manager manager) {
		managers.add(manager);
	}
	
	public List<Manager> getManagersList() {
		return this.managers;
	}
}
