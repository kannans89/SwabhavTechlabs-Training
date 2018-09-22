package com.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.entity.Transaction;
import com.banking.repo.TransactionRepo;

@Service
public class TransactionService {
	private TransactionRepo transactionRepo = null;
	
	@Autowired
	public void setRepo(TransactionRepo tRepo) {
		this.transactionRepo = tRepo;
	}
	public List<Transaction> getTransactions(String account_no){
		return this.transactionRepo.getTransactions(account_no);
	}
}
