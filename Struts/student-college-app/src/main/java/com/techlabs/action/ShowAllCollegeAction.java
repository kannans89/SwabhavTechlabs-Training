package com.techlabs.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.model.College;
import com.techlabs.service.CollegeService;

public class ShowAllCollegeAction extends ActionSupport{
	private List<College> college = null;
	private CollegeService service;
	
	public ShowAllCollegeAction() {
		service = CollegeService.getCollegeService();
	}
	
	public List<College> getCollege() {
		return college;
	}

	public void setCollege(List<College> college) {
		this.college = college;
	}

	public String execute() {
		college = service.getColleges();
		return "success";
	}
}
