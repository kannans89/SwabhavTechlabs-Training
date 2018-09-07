package com.techlabs.interceptors;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthenticateInterceptor extends AbstractInterceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("Inside auth interceptor init");
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("Inside auth interceptor");
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		String user = (String) session.get("username");
		System.out.println("User name from interceptor " + user);
		if (user == null) {
			return "login";
		}
		return invocation.invoke();
	}

}
