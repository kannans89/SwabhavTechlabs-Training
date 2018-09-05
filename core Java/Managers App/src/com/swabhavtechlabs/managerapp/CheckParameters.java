package com.swabhavtechlabs.managerapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckParameters {
	Database db = new Database();
	List<Manager> managers;
	
	public CheckParameters() {
		managers = db.retrieve();
		if(db.retrieve() == null) {
			managers = new ArrayList<>();
		} else {
			managers = db.retrieve();
		}
	}
	
	public boolean codeIsUnique(String code) {
		for(Manager manager: managers) {
			if(manager.getCode().equals(code))
				return false;
		}
		return true;
	}
	
	public boolean joiningGreaterThanBirthDate(Date birthdate, Date joiningDate) {
		if(joiningDate.after(birthdate))
			return true;
		else
			return false;
	}
	
	public boolean isCTCPositive(double ctc) {
		return ctc > 0;
	}
}
