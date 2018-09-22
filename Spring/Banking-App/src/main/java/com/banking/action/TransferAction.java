package com.banking.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.banking.service.AccountService;
import com.banking.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class TransferAction extends ActionSupport{
	private String account_number;
	private double amount; 
	private AccountService accountService = null;
	private UserService userService = null;
	
	@Autowired
	public void setAccountService(AccountService aService,UserService uService) {
		this.accountService = aService;
		this.userService = uService;
	}
	
	public String execute() {
		return SUCCESS;
	}
	
	public String transferAmount() {
		System.out.println("Inside deposit amount");
		System.out.println(account_number+" "+amount);
		String email = (String) ServletActionContext.getRequest().getSession().getAttribute("userEmail");
		System.out.println("Email from deposit action "+email);
		String from_acc_no = this.userService.getAccountNumberByEmail(email);
		System.out.println("current user is "+from_acc_no);
		boolean status = this.accountService.transferAmount(from_acc_no, account_number, amount);
		return SUCCESS;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
