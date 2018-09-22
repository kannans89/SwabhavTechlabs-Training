package com.banking.action;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate.BooleanOperator;

import org.springframework.beans.factory.annotation.Autowired;

import com.banking.entity.User;
import com.banking.service.AccountService;
import com.banking.service.UserService;
import com.banking.viewmodel.AdminViewModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminAction extends ActionSupport implements ModelDriven<AdminViewModel>{
	private List<User> accountHolders = null;
	private UserService userService = null;
	private AccountService accountService = null;
	private AdminViewModel adminBean = null;
	private List<String> accountStatus = null;
	
	@Autowired
	public void setService(UserService uService, AccountService aService) {
		this.userService = uService;
		this.accountService = aService;
	}
	
	public AdminAction() {
		this.accountHolders = new ArrayList<>();
		adminBean = new AdminViewModel();
		this.accountStatus = new ArrayList<>();
	}
	
	public String execute() {
		this.accountHolders = this.userService.getUsers();
		adminBean.setAccountHolders(accountHolders);
		
		for(User user:accountHolders) {
			boolean status = this.accountService.getAccountStatus(user.getEmail());
			System.out.println("Activation status "+status);
			if(status) {
				this.accountStatus.add("Activated");
			} else {
				this.accountStatus.add("Deactivated");
			}
		}
		
		adminBean.setAccountStatus(this.accountStatus);
		adminBean.createMap();
		System.out.println("Number of account holders "+accountHolders.size());
		return SUCCESS;
	}

	public List<User> getAccountHolders() {
		return accountHolders;
	}

	public void setAccountHolders(List<User> accountHolders) {
		this.accountHolders = accountHolders;
	}
	
	public AdminViewModel getAdminBean() {
		return adminBean;
	}

	public void setAdminBean(AdminViewModel adminBean) {
		this.adminBean = adminBean;
	}

	@Override
	public AdminViewModel getModel() {
		return adminBean;
	}
}
