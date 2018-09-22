package com.techlabs.actions;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlabs.entity.Employee;
import com.techlabs.repository.EmployeeRepository;

public class EmployeeAction implements Action {
	private EmployeeRepository empRepo = null;
	private Employee employeeBean;
	private Employee updateEmployeeBean;

	public EmployeeAction() {
		employeeBean = new Employee();
		updateEmployeeBean = new Employee();
	}

	@Autowired
	public void setEmpRepo(EmployeeRepository repo) {
		this.empRepo = repo;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("AddEmployee: Inside execeute");
		return SUCCESS;
	}
	
	public String addToDB() {
		System.out.println("AddEmployee: Inside addToDB method");
		System.out.println(employeeBean.getFirst_name());
		Employee employee = new Employee(Math.abs(UUID.randomUUID().getMostSignificantBits()),
				employeeBean.getFirst_name(), employeeBean.getLast_name(), employeeBean.getSalary(),
				employeeBean.getContact());
		System.out.println("First Name: "+employee.getFirst_name());
		System.out.println("Last Name: "+employee.getLast_name());
		System.out.println("Salary : "+employee.getSalary());
		System.out.println("Contact: "+employee.getContact());
		this.empRepo.addEmployee(employee);
		return SUCCESS;
	}
	
	public String deleteEmployee() {
		System.out.println("Inside delete employee");
		String id = ServletActionContext.getRequest().getParameter("id");
		System.out.println("Id is "+id);
		this.empRepo.deleteEmployee(id);
		return SUCCESS;
	}
	
	
	public String editEmployee() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		System.out.println("Inside Edit employee(form)");
		String id = ServletActionContext.getRequest().getParameter("id");
		System.out.println("Id is "+id);
		session.setAttribute("empId", id);
		employeeBean = this.empRepo.getEmployeeById(id);
		System.out.println(employeeBean.getFirst_name());
		return SUCCESS;
	}
	
	public String updateEmployee() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		String id = "";
		
		if(session.getAttribute("empId") != null) {
			id = (String) session.getAttribute("empId");
		}
		System.out.println("Inside Edit employee(db)");
		System.out.println("Id is "+id);
		System.out.println("Updated name is "+updateEmployeeBean.getFirst_name());
		this.empRepo.updateEmployee(new Employee(Long.parseLong(id), updateEmployeeBean.getFirst_name(), updateEmployeeBean.getLast_name(), updateEmployeeBean.getSalary(), updateEmployeeBean.getContact()));
		session.removeAttribute("empId");
		return SUCCESS;
	}

	public Employee getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(Employee employee) {
		this.employeeBean = employee;
	}

	public Employee getUpdateEmployeeBean() {
		return updateEmployeeBean;
	}

	public void setUpdateEmployeeBean(Employee updateEmployeeBean) {
		this.updateEmployeeBean = updateEmployeeBean;
	}
}
