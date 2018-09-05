package com.mvc.service;

import java.util.ArrayList;
import java.util.List;

import com.mvc.model.User;

public class AuthenticationService {
	static AuthenticationService authService = null;
	private List<User> users = null;
	
	private AuthenticationService() {
		users = new ArrayList<>();
		createUsers();
	}
	
	public static AuthenticationService getAuthService() {
		System.out.println("inside auth service");
		if(authService == null) {
			authService = new AuthenticationService();
			System.out.println("Inside object creation of Auth Service");
			return authService;
		}
		System.out.println("Inside auth service outside if");
		return authService;
	}
	
	private void createUsers() {
		users.add(new User("Manoj", "123456"));
		users.add(new User("Varshil", "1234"));
	}
	
	public boolean checkUser(User authenticateUser) {
		for(User user: users) {
			if(user.getUsername().equals(authenticateUser.getUsername())) {
				if(user.getPassword().equals(authenticateUser.getPassword())) {
					return true;
				}
			}
		}
		return false;
	}
}
