package com.techlabs.action;

import com.opensymphony.xwork2.Action;

public class HomeAction implements Action{

	private String Student="Manoj";
	
	public String getStudent() {
		System.out.println("cvdshbh");
		return Student;
	}
	
	public void setStudent(String student) {
		this.Student = student;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("Inside Home action");
		
		return "success";
	}

}
