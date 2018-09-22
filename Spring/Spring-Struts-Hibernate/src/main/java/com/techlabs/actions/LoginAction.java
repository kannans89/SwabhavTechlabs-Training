package com.techlabs.actions;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.service.LoginService;

public class LoginAction extends ActionSupport  implements SessionAware {
	private static final long serialVersionUID = 1L;
	private LoginService loginService = null;
	private Map<String , Object> userSession = null;
	private String email;
	private String password;
	
	@Autowired
	public void setService(LoginService service) {
		this.loginService = service;
	}
	
	public String execute() {
		System.out.println("Inside login execute");
		return SUCCESS;
	}
	
	public String logoutUser() {
		System.out.println("inside log out user");
		this.userSession.remove("userEmail");
		this.loginService.setLoggedInState(false);
		return SUCCESS;
	}
	
	public String loginUser() {
		System.out.println("Inside login user");
		System.out.println("Email: "+email);
		System.out.println("Password: "+password);
		
		if(this.loginService.authenticateUser(email, password)) {
			System.out.println("Inside login user authentication successfull");
			userSession.put("userEmail", email);
			return SUCCESS;
		}
		return "login";
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.userSession = session;
	}
}
