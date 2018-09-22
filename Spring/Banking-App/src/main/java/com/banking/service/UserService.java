package com.banking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.entity.User;
import com.banking.repo.UserRepo;

@Service
public class UserService {
	private UserRepo userRepo = null;
	private List<User> users = null;
	
	public UserService() {
		this.users = new ArrayList<>();
	}
	
	@Autowired
	public void setUserRepo(UserRepo repo) {
		this.userRepo = repo;
	}
	
	public void addUser(User user) {
		this.userRepo.addUser(user);
	}
	
	public String getAccountNumberByEmail(String email) {
		return this.userRepo.getAccountNumberByEmail(email);
	}
	
	public boolean isEmailPresent(String email) {
		return this.userRepo.isEmailPresent(email);
	}
	
	public List<User> getUsers(){
		this.users = this.userRepo.getUsers();
		return users;
	}
}
