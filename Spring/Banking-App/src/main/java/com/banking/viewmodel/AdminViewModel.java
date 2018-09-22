package com.banking.viewmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.banking.entity.User;

public class AdminViewModel {
	private List<User> accountHolders = null;
	private List<String> accountStatus = null;
	Map<User, String> accountHoldersMap = new HashMap<>();
	
	public AdminViewModel() {
		this.accountHolders = new ArrayList<>();
		this.accountStatus = new ArrayList<>();
	}

	public List<User> getAccountHolders() {
		return accountHolders;
	}

	public void setAccountHolders(List<User> accountHolders) {
		
		this.accountHolders = accountHolders;
		System.out.println("Account holders from admin view model "+this.accountHolders.size());
	}

	public List<String> getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(List<String> accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	public void createMap() {
		int i = 0;
		for(User user: accountHolders) {
			System.out.println(accountStatus.get(i)+" "+user.getEmail());
			if(user.getFirst_name().equals("Admin")) {
				i=i+1;
				continue;
			}
			accountHoldersMap.put(user, accountStatus.get(i));
			System.out.println("i is "+i);
			i=i+1;
		}
		System.out.println("Account holders map size is "+accountHoldersMap.size());
		
	}

	public Map<User, String> getAccountHoldersMap() {
		return accountHoldersMap;
	}

	public void setAccountHoldersMap(Map<User, String> accountHoldersMap) {
		this.accountHoldersMap = accountHoldersMap;
	}
	
	
}
