package com.swabhavtechlabs.csvLoader;

import java.util.ArrayList;
import java.util.List;
public class Analyzer{
	URLLoader url = new URLLoader();
	DiskLoader disk = new DiskLoader();
	Parser parser = new Parser(url);
	List<String> records = null;
	List<Employee> employees;
	
	public void fetchRecords() {
		 employees = parser.getRecords();
	}
	
	public Employee maxSalariedEmployee() {
		Employee maxSalariedEmployee = employees.get(0);
		for(int j = 1; j<employees.size(); j++) {
			if(maxSalariedEmployee.getSalary() < employees.get(j).getSalary()) {
				maxSalariedEmployee = employees.get(j);
			}
		}
		return maxSalariedEmployee;
	}
	
	public List<String> findTotalNumberOfEmployeesDeptNo(int deptNo){
		List<String> numberOfEmployeesDeptNo = new ArrayList<>();
		int i = 0;
		for(Employee employee: employees) {
			if(employee.getDeptNo() == deptNo) {
				numberOfEmployeesDeptNo.add(employee.getName());
			}
		}
		return numberOfEmployeesDeptNo;
	}
	
	public List<String> findTotalNumberOfEmployeesDesignation(String designation){
		List<String> numberOfEmployeesDesignation = new ArrayList<>();
		for(Employee employee: employees) {
			String compare = employee.getDesignation();
			if(compare.equals(designation)) {
				numberOfEmployeesDesignation.add(employee.getName());
			}
		}
		return numberOfEmployeesDesignation;
	}
}
