package com.swabhavtechlabs.csvLoader;

public class Employee {
	private int id, deptNo;
	private String designation, name, managerID, dateOfJoining;
	private double salary;

	public Employee(int id, String designation, String name, String managerID, String dateOfJoining, double salary,
			int deptNo) {
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.managerID = managerID;
		this.dateOfJoining = dateOfJoining;
		this.salary = salary;
		this.deptNo = deptNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getManagerID() {
		return managerID;
	}

	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
