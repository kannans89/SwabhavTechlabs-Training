package com.swabhavtechlabs.managerapp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Administrator {
	List<Manager> managers = null;
	Database db = new Database();
	Bank bank = new Bank();
	
	public Administrator() {
		managers = bank.getManagersList();
	}
	
	public void addManager(Manager manager) throws ParseException{
		bank.addToManagerList(manager);
	}
	
	public void saveTodatabase() {
		db.save(managers);
	}
}
