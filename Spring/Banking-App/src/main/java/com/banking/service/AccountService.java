package com.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.entity.Account;
import com.banking.repo.AccountRepo;
import com.banking.repo.UserRepo;

@Service
public class AccountService {
	private AccountRepo accountRepo = null;
	private UserRepo userRepo = null;
	
	@Autowired
	public void setAccountRepo(AccountRepo repo, UserRepo uRepo) {
		this.accountRepo = repo;
		this.userRepo = uRepo;
	}
	
	public boolean activateAccount(String account_no) {
		boolean status = this.accountRepo.getAccountStatus(account_no);
		if(!status) {
			this.accountRepo.activateAccount(account_no);
			return true;
		}
		return false;
	}
	
	public void addAccount(Account a) {
		this.accountRepo.addAccount(a);
	}
	
	public boolean getAccountStatus(String email) {
		String acc_no = this.userRepo.getAccountNumberByEmail(email);
		return this.accountRepo.getAccountStatus(acc_no);
	}
	
	public boolean transferAmount(String from_acc_no, String to_acc_no, double amount) {
		boolean accountFound = this.accountRepo.checkAccountNumber(to_acc_no);
		if(accountFound) {
			this.accountRepo.transferAmount(from_acc_no,to_acc_no, amount);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean depositAmount(String account_no, double amount) {
		return this.accountRepo.depositAmount(account_no, amount);
	}
	
	public boolean withdrawAmount(String acc_no, double amount) {
		return this.accountRepo.withDraw(acc_no, amount);
	}
	
	public void lockAccount(String email) {
		String account_no = this.userRepo.getAccountNumberByEmail(email);
		this.accountRepo.lockAccount(account_no);
	}
}
