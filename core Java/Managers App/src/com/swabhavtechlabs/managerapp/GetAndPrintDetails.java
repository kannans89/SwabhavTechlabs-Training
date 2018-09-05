package com.swabhavtechlabs.managerapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetAndPrintDetails {
	public void printDetails(java.util.List<Manager> managers) {
		for(Manager manager: managers) {
			System.out.print(manager.getName()+"\t");
			System.out.print(manager.getCode()+"\t");
			System.out.print(manager.getBirthDate()+"\t");
			System.out.print(manager.getSpecilization()+"\t");
			System.out.print(manager.getJoiningDate()+"\t");
			System.out.print(manager.getCtc()+"\t");
			System.out.println();
		}
	}
	
	public Manager getDetails() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		String name = "Manoj";
		String code = "104";		
		Specilization specilization = Specilization.INSURANCE;
		Date birthDate = sdf.parse("1997-03-03");
		Date joiningDate = sdf.parse("2016-06-20");	
		double ctc = 1500;
		return new Manager(name, code, specilization, birthDate, joiningDate, true, ctc);
	}
}
