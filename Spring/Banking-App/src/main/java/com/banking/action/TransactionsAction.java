package com.banking.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.banking.entity.Transaction;
import com.banking.service.TransactionService;
import com.banking.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TransactionsAction extends ActionSupport {
	private List<Transaction> transactions = null;
	private TransactionService transactionService = null;
	private UserService userService = null;
	private String current_user = "Manoj";
	
	@Autowired
	public void setService(TransactionService tService, UserService uService) {
		this.transactionService = tService;
		this.userService = uService;
	}
	
	public TransactionsAction() {
		transactions = new ArrayList<>();
	}
	public String execute() {
		String email = (String) ServletActionContext.getRequest().getSession().getAttribute("userEmail");
		String account_no = this.userService.getAccountNumberByEmail(email);
		this.transactions = this.transactionService.getTransactions(account_no);
		//System.out.println(this.transactions.get(0));
		return SUCCESS;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public String getCurrent_user() {
		return current_user;
	}

	public void setCurrent_user(String currenr_user) {
		this.current_user = currenr_user;
	}
}
