package com.techlabs.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;

@Entity
public class Employee {

	@Id
	@Column(name="Emp_id", unique=true, nullable=false)
	private int emp_id;
	
	@Column(name="Emp_name", nullable=false)
	private String emp_name;
	
	@Column(name="Salary", nullable=false)
	private double salary;
	
	@ManyToOne
	@JoinColumn(name="Dept_id")
	private Department department;
	
	public Employee() {}
	
	public Employee(int emp_id, String emp_name, double salary, Department dept) {
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.salary = salary;
		this.department = dept;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
