package com.techlabs.action;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.service.StudentService;

public class DeleteStudent extends ActionSupport{
	String studentId;
	StudentService service;
	
	public DeleteStudent() {
		studentId = ServletActionContext.getRequest().getParameter("id");
		service = StudentService.getStudentService();
	}
	
	public String execute() throws Exception {
		service.deleteStudentById(studentId);
		return SUCCESS;
	}
}
