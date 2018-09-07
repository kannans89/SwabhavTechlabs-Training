package com.techlabs.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.model.College;
import com.techlabs.service.CollegeService;

public class ShowCollege extends ActionSupport{
	CollegeService service = null;
	College college = null;
	
	
	public ShowCollege() {
		service = CollegeService.getCollegeService();
	}
	
	public String execute() {
		String id = ServletActionContext.getRequest().getParameter("col_id");
		System.out.println("College id "+id);
		college = service.getCollegeById(id);
		System.out.println(college.getName());
		return "success";
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}
}
