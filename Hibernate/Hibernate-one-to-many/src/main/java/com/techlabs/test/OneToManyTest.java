package com.techlabs.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.techlabs.entity.Department;
import com.techlabs.entity.Employee;
import com.techlabs.utilities.HibernateUtilities;

public class OneToManyTest {
	public static void main(String[] args) {
		HibernateUtilities  hbUtilities = new HibernateUtilities();
		Session hbsession = hbUtilities.getSessionFactory().openSession();
		
		Department compDepartment = new Department();
		compDepartment.setDept_name("computer");
		compDepartment.setDept_id(101);
		
		Set<Employee> employees = new HashSet<>(); //comp employees
		Set<Employee> itEmployees = new HashSet<>();
		
		Employee employee1 = new Employee(101, "Manoj", 15000, compDepartment);
		Employee employee2 = new Employee(102, "Shubham", 25000, compDepartment);
		Employee employee3 = new Employee(103, "Chandan", 35000, compDepartment);
		
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		
		compDepartment.setEmployees(employees);
		
		Department ITDepartment = new Department();
		ITDepartment.setDept_name("IT");
		ITDepartment.setDept_id(102);
		Employee employee4 = new Employee(104, "Varshil", 25000, ITDepartment);
		Employee employee5 = new Employee(105, "Dharmesh", 5000, ITDepartment);
		itEmployees.add(employee4);
		itEmployees.add(employee5);
		
		ITDepartment.setEmployees(itEmployees);
		
//		hbsession.beginTransaction();
//		hbsession.save(compDepartment);
//		hbsession.save(employee1);
//		hbsession.save(employee2);
//		hbsession.save(employee3);
		
//		hbsession.save(ITDepartment);
//		hbsession.save(employee4);
//		hbsession.save(employee5);
		
		hbsession.getTransaction().commit();
		hbsession.close();
	}
}
