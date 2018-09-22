package com.banking.interceptor;

import org.springframework.beans.factory.annotation.Autowired;

import com.banking.service.LoginService;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	private LoginService loginService = null;
	
	@Autowired
	public void setService(LoginService service) {
		this.loginService = service;
	}
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("Inside login interceptor intercept method");
		String actionName = invocation.getAction().getClass().getName();
		if(loginService.isLoggedInState()) {
			System.out.println("Logged in true action name is "+actionName);
			return invocation.invoke();
		} else {
			return "login";
		}
	}

}
