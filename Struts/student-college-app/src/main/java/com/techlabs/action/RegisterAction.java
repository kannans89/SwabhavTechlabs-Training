package com.techlabs.action;

import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.model.User;

public class RegisterAction extends ActionSupport{
	private User userBean;
	
	public void validate() {
		System.out.println("Inside user reg validate");
		if(userBean.getFirstName().length() == 0) {
			addFieldError("userBean.firstName", "First Name is required");
		}
		if(userBean.getEmail().length() == 0) {
			addFieldError("userBean.email", "Email is required");
		}
		if(userBean.getPassword().length() == 0) {
			addFieldError("userBean.password", "Password is required");
		}
		if(userBean.getAge() <18) {
			addFieldError("userBean.age", "Age must be greater than 18");
		}
	}
	
	public String execute() {
		return SUCCESS;
	}

	public User getUserBean() {
		return userBean;
	}

	public void setUserBean(User userBean) {
		this.userBean = userBean;
	}
}
