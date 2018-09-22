package com.banking.action;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.banking.entity.Account;
import com.banking.entity.User;
import com.banking.service.AccountService;
import com.banking.service.UserService;
import com.banking.viewmodel.UserViewModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.techlabs.utility.HashGenerator;

public class RegisterAction extends ActionSupport implements ModelDriven<UserViewModel>{

	private static final long serialVersionUID = 1L;
	private UserViewModel userBean = null;
	private UserService userService = null;
	private AccountService accountService = null;
	HashGenerator hashGen = null;
	
	@Autowired
	public void setService(UserService service, AccountService aService) {
		this.accountService = aService;
		this.userService = service;
	}
	
	public RegisterAction() {
		userBean = new UserViewModel();
		hashGen = new HashGenerator();
	}
	
	public String execute() {
		return SUCCESS;
	}
	
	public String addUserToDB() {
		System.out.println("Inside addusertodb");
		System.out.println("First name "+userBean.getFirst_name());
		String email = userBean.getEmail();
		
		if(!this.userService.isEmailPresent(email)) {
			addFieldError("email", "Email already exists");
			return "input";
		}

		User user = createUser();
		Account account = new Account("Primary", 10000);
		account.setUser(user);
		user.setAccount(account);	
		this.userService.addUser(user);
		this.accountService.addAccount(account);
		return SUCCESS;
	}
	
	public User createUser() {
		String account_no = UUID.randomUUID().getMostSignificantBits()+"";
		String hashedPassword = hashGen.hashPassword(userBean.getPassword());
		System.out.println("Hashed password is "+hashedPassword);
		User user = new User(account_no, "member", userBean.getFirst_name(), userBean.getLast_name(), userBean.getEmail(), userBean.getUsername(), hashedPassword, userBean.getDob(), userBean.getContact());
		return user;
	}
	
	@Override
	public UserViewModel getModel() {
		return userBean;
	}

	public UserViewModel getUserBean() {
		return userBean;
	}

	public void setUserBean(UserViewModel userBean) {
		this.userBean = userBean;
	}
	
}
