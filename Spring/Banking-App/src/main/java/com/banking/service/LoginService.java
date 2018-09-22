package com.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.entity.User;
import com.banking.repo.UserRepo;
import com.techlabs.utility.HashGenerator;

@Service
public class LoginService {
	private boolean loggedInState = false;
	private UserRepo userRepo = null;
	private HashGenerator obj = new HashGenerator();
	
	@Autowired
	public void setRepo(UserRepo repo) {
		this.userRepo = repo;
	}
	
	public boolean authenticateUser(String email, String password) {
		User user = this.userRepo.findUser(email, password);
		System.out.println("retreving password from db "+user.getPassword());
		System.out.println("Inserted password "+password);
		boolean status = obj.checkPassword(password, user.getPassword());
		
		if(status) {
			this.loggedInState = true;
			return loggedInState;
		}
		return loggedInState;
	}

	public boolean isLoggedInState() {
		//System.out.println("User email "+userSession.get("userEmail"));
		return loggedInState;
	}

	public void setLoggedInState(boolean loggedInState) {
		this.loggedInState = loggedInState;
	}
	
	public boolean checkRole(String email, String password) {
		User user = this.userRepo.findUser(email, password);
		String hash = user.getPassword();
		boolean status = obj.checkPassword(password, hash);
		if(status) {
			if(user.getRole().equals("admin")) {
				System.out.println("user role is "+user.getRole());
				this.loggedInState = true;
				return true;
			} else {
				return false;
			}
		} return false;
	}
}
