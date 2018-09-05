package com.techlabs.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.Action;

public class BrowseAction implements Action{

	private Date date = new Date();
	private boolean postback = false;
	private String methodType = "get";
	
	public BrowseAction() {
	}
	
	public String getDate() {
		System.out.println("inside getdate");
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(dateFormat.format(date));
		return dateFormat.format(date);
	}
	

	
	public boolean isPostback() {
		System.out.println("inside postback "+postback);
		return postback;
	}



	public void setPostback(boolean postback) {
		System.out.println("inside postback "+postback);
		setMethodType("post");
		System.out.println("Postback is "+postback);
		this.postback = postback;
	}



	public String getMethodType() {
		System.out.println("inside getmethod type "+methodType);
		return methodType;
	}



	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}



	@Override
	public String execute() throws Exception {
		System.out.println("Inside Browse action");
		return "success";
	}

}
