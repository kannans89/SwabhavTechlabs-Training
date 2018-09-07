package com.techlabs.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	private Map<String, Object> userSession = null;
	@Override
	public void setSession(Map<String, Object> session) {
		userSession = session;
	}
	
	public String execute() {
		String userName = ServletActionContext.getRequest().getParameter("username");
		String password = ServletActionContext.getRequest().getParameter("password");
		
		if(!(userName == null || password == null)) {
			if((!userName.equals("")&&userName.equals("manu")) && (password.equals("root")&&!userName.equals(""))) {
				userSession.put("username", userName);
				return SUCCESS;
			}
		}
		return ERROR;
	}

}
