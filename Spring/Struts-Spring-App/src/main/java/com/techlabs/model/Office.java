package com.techlabs.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.techlabs.service.EmployeeService;

public class Office {
	private EmployeeService service = null;
	private String add;
	private List<Employee> employees = null;
	
	public Office() {}
	
	public Office(String add) {
		this.add = add;
		employees = new ArrayList<>();
	}
	
	@Autowired
	public void setService(EmployeeService service) {
		this.service = service;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
