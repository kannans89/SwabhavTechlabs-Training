package com.techlabs.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.entity.Employee;
import com.techlabs.repository.EmployeeRepository;

public class ShowEmployeesAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private EmployeeRepository empRepo = null;
	private List<Employee> employees = null;

	public ShowEmployeesAction() {
		employees = new ArrayList<>();
	}

	@Autowired
	public void setEmpRepo(EmployeeRepository repo) {
		this.empRepo = repo;
	}

	@Override
	public String execute() {
		System.out.println("Inside execute show employee");
		this.employees = empRepo.getAllEmployees();
		System.out.println("Number of employees " + employees.size());
		return SUCCESS;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
