package com.banking.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.banking.service.AccountService;
import com.opensymphony.xwork2.ActionSupport;

public class UnlockAction extends ActionSupport{
	private AccountService accountService = null;
	
	@Autowired
	public void setService(AccountService aService) {
		this.accountService = aService;
	}
	public String execute() {
		String acc_no = ServletActionContext.getRequest().getParameter("account_no");
		System.out.println("Unlocking acount "+acc_no);
		Boolean status = this.accountService.activateAccount(acc_no);
		if(status) {
			System.out.println("Account activated");
		}
		return SUCCESS;
	}
}
