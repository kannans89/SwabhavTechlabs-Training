package com.banking.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.banking.service.AccountService;
import com.banking.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class WithdrawAction extends ActionSupport{
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
	
	public String withdrawAmount() {
		System.out.println("Inside withdraw amount");
		System.out.println(amount);
		String email = (String) ServletActionContext.getRequest().getSession().getAttribute("userEmail");
		System.out.println("Email from withdraw action "+email);
		String acc_no = this.userService.getAccountNumberByEmail(email);
		System.out.println("current user is "+acc_no);
		boolean status = this.accountService.withdrawAmount(acc_no, amount);
		System.out.println("Withdraw status is "+status);
		if(!status) {
			addFieldError("error", "You dont have enough money!");
			return "input";
		}
		return SUCCESS;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
