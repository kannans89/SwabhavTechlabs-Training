package com.techlabs.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware{
	private Map<String, Object> userSession;
	
	@Override
	public String execute() {
		System.out.println("In logout action 1");
		userSession.put("username", null);
		System.out.println("In logout action 2");
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.userSession = session;
		
	}

	public Map<String, Object> getUserSession() {
		return userSession;
	}

	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}
}
