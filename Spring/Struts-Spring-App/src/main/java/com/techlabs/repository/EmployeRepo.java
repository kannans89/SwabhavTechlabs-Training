package com.techlabs.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.techlabs.model.Car;
import com.techlabs.model.Employee;
import com.techlabs.model.Home;
import com.techlabs.model.Office;

@Repository
public class EmployeRepo {
	private List<Employee> employees;
	
	public EmployeRepo() {
		System.out.println("Employee repo created");
		employees = new ArrayList<>();
		createEmployees();
	}
	
	private void createEmployees() {
		employees.add(new Employee(101, "Manoj", "Virar", new Car(123, "Audi", 123456), new Home(502, "Holy", "Virar"), new Office("Bandra")));
		employees.add(new Employee(102, "Varshil", "Virar", new Car(123, "Audi", 123456), new Home(503, "Holy", "Virar"), new Office("Bandra")));
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
