package com.techlabs.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techlabs.entity.Employee;

@Repository
public class EmployeeRepository {
	private SessionFactory factory = null;
	private Session session = null;
	private List<Employee> employees = null;

	public EmployeeRepository() {
		this.employees = new ArrayList<Employee>();
	}

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public List<Employee> getAllEmployees() {
		System.out.println("Inside get all employee");
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Employee");
		this.employees = query.list();

		session.getTransaction().commit();
		session.close();
		return this.employees;
	}

	public void addEmployee(Employee employee) {
		System.out.println("Inside add employee");
		session = factory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteEmployee(String id) {
		System.out.println("Inside Delete employee");
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("delete Employee where id = :id");
		query.setParameter("id", Long.parseLong(id));
		int result = query.executeUpdate();
		if (result > 0) {
			System.out.println("Employee deleted successfully");
		}
		session.getTransaction().commit();
		session.close();
	}

	@Transactional
	public Employee getEmployeeById(String id) {
		System.out.println("Inside get emp by id");
		Employee employee = null;
		session = factory.openSession();
		session.beginTransaction();
		employee = (Employee) session.load(Employee.class, Long.parseLong(id));
		session.getTransaction().commit();
		session.close();
		System.out.println("Got employee");
		return employee;

	}

	public void updateEmployee(Employee updatedEmployee) {
		System.out.println("Inside update emp by id");
		session = factory.openSession();
		session.beginTransaction();
		Employee employee = (Employee) session.load(Employee.class, updatedEmployee.getId());

		employee.setContact(updatedEmployee.getContact());
		employee.setFirst_name(updatedEmployee.getFirst_name());
		employee.setLast_name(updatedEmployee.getLast_name());
		employee.setSalary(updatedEmployee.getSalary());

		session.getTransaction().commit();
		session.close();
	}
}
