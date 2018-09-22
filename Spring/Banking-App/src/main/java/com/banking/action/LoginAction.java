package com.banking.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.banking.entity.User;
import com.banking.service.AccountService;
import com.banking.service.LoginService;
import com.banking.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private String email;
	private String password;
	private static int attempts = 3;

	private Map<String, Object> userSession = null;
	private LoginService loginService = null;
	private AccountService accountService = null;

	@Autowired
	public void setLoginService(LoginService logService, AccountService accService) {
		this.loginService = logService;
		this.accountService = accService;
	}

	@Override
	public void validate() {

	}

	public String execute() {
		return SUCCESS;
	}

	public String logoutUser() {
		userSession.remove("userEmail");
		this.loginService.setLoggedInState(false);
		return SUCCESS;
	}

	public String loginUser() {
		Boolean status;
		attempts -= 1;
		
		
		System.out.println("Email " + email + "Password " + password);

		boolean adminStatus = this.loginService.checkRole(email, password);
		if (adminStatus) {
			System.out.println("Logged user is admin");
			return "admin";
		} else {
			status = this.accountService.getAccountStatus(email);
			System.out.println("Account activated " + status);
			if (!status) {
				
				addFieldError("activate", "You must activate your account!");
				return "input";
			}

			if (this.loginService.authenticateUser(email, password)) {
					userSession.put("userEmail", email);
					return SUCCESS;
			}else {
				System.out.println("number of attempts remaining "+attempts);
					if (attempts >0) {
						addActionMessage("Login attempts remaining " + attempts);
					} else {
						this.accountService.lockAccount(email);
						addActionMessage("Your account gets locked, please contact admin to re-activate account");
					}
					addFieldError("errorAuth", "Invalid email or password");
					return "input";

				}

//			} else {
//				if (attempts <= 3) {
//					addActionMessage("Login attempts remaining " + attempts);
//				}
//				addFieldError("errorAuth", "Invalid email or password");
//				return "login";
//			}
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.userSession = session;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
