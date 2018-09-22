package com.banking.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.banking.entity.Account;
import com.banking.service.AccountService;
import com.banking.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class ActivateAccountAction extends ActionSupport{
	private UserService userService = null;
	private AccountService accountService = null;
	
	@Autowired
	public void setService(UserService service, AccountService aService) {
		this.userService = service;
		this.accountService = aService;
	}
	
	public String execute() {
		String email = ServletActionContext.getRequest().getParameter("email");
		System.out.println("Email from activate account action "+email);
		String account_no = this.userService.getAccountNumberByEmail(email);
		boolean activated = this.accountService.activateAccount(account_no);
		if(!activated) {
			System.out.println("Account with account number "+account_no+" is already activated");
		}
		return SUCCESS;
	}
}
