package com.techlabs.actions;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlabs.service.EmployeeService;

public class WelcomeAction implements Action {

	private EmployeeService service = null;

	@Autowired
	public void setService(EmployeeService service) {
		this.service = service;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("Welcome to struts-spring app");
		System.out.println(service.getSingleEmployee().getName());
		return SUCCESS;
	}

}
