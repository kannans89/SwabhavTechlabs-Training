package com.techlabs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.repository.UserRepository;

@Service
public class LoginService{
	private boolean loggedInState = false;
	private UserRepository userRepo = null;
	
	@Autowired
	public void setRepo(UserRepository repo) {
		this.userRepo = repo;
	}
	
	public boolean authenticateUser(String email, String password) {
		if(this.userRepo.findUser(email, password)) {
			this.loggedInState = true;
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
}
