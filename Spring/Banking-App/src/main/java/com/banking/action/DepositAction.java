package com.banking.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.banking.service.AccountService;
import com.banking.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class DepositAction extends ActionSupport{
	private double amount;
	private UserService userService = null;
	private AccountService accountService = null;
	
	@Autowired
	public void setService(UserService uService, AccountService aService) {
		this.userService = uService;
		this.accountService = aService;
	}
	
	public String execute() {
		return SUCCESS;
	}
	
	public String depositAmount() {
		System.out.println("Inside deposit amount");
		System.out.println(amount);
		String email = (String) ServletActionContext.getRequest().getSession().getAttribute("userEmail");
		System.out.println("Email from deposit action "+email);
		String acc_no = this.userService.getAccountNumberByEmail(email);
		System.out.println("current user is "+acc_no);
		boolean status = this.accountService.depositAmount(acc_no, amount);
		
		return SUCCESS;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
