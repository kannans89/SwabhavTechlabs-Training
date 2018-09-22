package com.techlabs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.model.Employee;
import com.techlabs.repository.EmployeRepo;

@Service
public class EmployeeService {
	
	private EmployeRepo repo = null;
	
	public EmployeeService() {
		System.out.println("Employee service is created");
	}
	
	@Autowired
	public void setService(EmployeRepo eRepo) {
		this.repo = eRepo;
	}
	
	public List<Employee> getEmployees() {
		return this.repo.getEmployees();
	}
	
	public Employee getSingleEmployee() {
		return this.repo.getEmployees().get(0);
	}
}
