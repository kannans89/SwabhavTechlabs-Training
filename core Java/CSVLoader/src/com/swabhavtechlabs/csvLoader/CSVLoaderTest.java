package com.swabhavtechlabs.csvLoader;

import java.util.ArrayList;
import java.util.List;

public class CSVLoaderTest {
	
	public static void displayRecords(List<String[]> records) {
		for(String[] strArray: records) {
			System.out.println("Record of "+strArray[1]);
		}
	}
	
	public static void displayEmployees(List<Employee> employees) {
		System.out.println("ID\tDesignation\tName\tManager ID\tDate of joining\tSalary\tDept No");
		System.out.println("-----\t------------\t------\t------- ID\t----------------\t-------\t-------");
		for(Employee employee: employees) {
			System.out.print(employee.getId()+"\t");
			System.out.print(employee.getDesignation()+"\t");
			System.out.print(employee.getName()+"\t");
			System.out.print(employee.getManagerID()+"\t");
			System.out.print(employee.getDateOfJoining()+"\t");
			System.out.print(employee.getSalary()+"\t");
			System.out.print(employee.getDeptNo()+"\t");
			System.out.println();
			System.out.println("------------------------------------------------------------------------------------------------");
			System.out.println("");
		}
	}
	
	public static void employeesBasedOnDeptNo(List<String> strList) {
		System.out.println("Employees based on dept number "+strList.size());
		for(String str: strList) {
			System.out.println(str);
		}
	}
	
	public static void employeesBasedOnDesignation(List<String> strList) {
		System.out.println("Employees based on Designation "+strList.size());
		for(String str: strList) {
			System.out.println(str);
		}
	}
	
	public static void main(String[] args) {
		Analyzer analyzer = new Analyzer();
		
	}
}
