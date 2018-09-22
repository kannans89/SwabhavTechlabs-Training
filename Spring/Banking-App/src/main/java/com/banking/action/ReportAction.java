package com.banking.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.banking.entity.Transaction;
import com.banking.service.TransactionService;
import com.banking.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class ReportAction extends ActionSupport{
	
	private TransactionService transactionService = null;
	private UserService userService = null;
	
	@Autowired
	public void setService(TransactionService tservice, UserService uservice) {
		this.transactionService = tservice;
		this.userService = uservice;
	}
	
	public String execute() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/csv");
		String report = "transactions.csv";
		response.setHeader("Content-disposition", "attachment;filename="+report);
		
		String email = (String) ServletActionContext.getRequest().getSession().getAttribute("userEmail");
		String acc_no = this.userService.getAccountNumberByEmail(email);
		List<Transaction> transactions = this.transactionService.getTransactions(acc_no);
		
		for(Transaction t:transactions) {
			String output = getOutputString(t);
			response.getOutputStream().print(output);
		}
		response.getOutputStream().flush();
		
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getOutputString(Transaction t) {
		String str = t.getId()+","+t.getType()+","+t.getDate()+","+t.getReceiver()+","+t.getPrevBalance()+","+t.getNewBalance()+"\n";
		return str;
		
	}
}
