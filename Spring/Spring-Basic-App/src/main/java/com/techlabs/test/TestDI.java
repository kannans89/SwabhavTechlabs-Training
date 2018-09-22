package com.techlabs.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techlabs.model.Employee;
import com.techlabs.service.EmployeeService;

public class TestDI {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		EmployeeService eService = context.getBean(EmployeeService.class);
		Employee emp1 = eService.getSingleEmployee();
		System.out.println(emp1.getName()+" "+emp1.getAddress());
		emp1.getOffice().setAdd("Borivali");
		System.out.println("Office add: "+emp1.getOffice().getAdd());
	}
}
