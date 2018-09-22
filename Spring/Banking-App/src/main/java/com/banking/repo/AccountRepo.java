package com.banking.repo;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.banking.entity.Account;
import com.banking.entity.Transaction;
import com.banking.entity.User;

@Repository
public class AccountRepo {
	private SessionFactory factory = null;
	private Session session = null;
	private UserRepo userRepo = null;
	
	@Autowired
	public void setFactory(SessionFactory factory, UserRepo uRepo) {
		this.factory = factory;
		this.userRepo = uRepo;
	}
	
	public void addAccount(Account a) {
		session = factory.openSession();
		session.beginTransaction();
		session.save(a);
		session.getTransaction().commit();
		session.close();
	}
	
	public boolean getAccountStatus(String account_no) {
		System.out.println("Getting account status "+account_no);
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Account where account_no = :account_no");
		query.setParameter("account_no", account_no);
		List<Account> account = query.list();
		session.getTransaction().commit();
		session.close();
		return account.get(0).isActivated();
	}
	
	public void activateAccount(String acc_no) {
		System.out.println("Activating account "+acc_no);
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("update Account set activated = :activated"+" where account_no=:account_no");
		query.setParameter("activated", true);
		query.setParameter("account_no", acc_no);
		int result = query.executeUpdate();
		session.getTransaction().commit();
		System.out.println("After updating result is "+result);
		session.close();
	}
	
	public boolean checkAccountNumber(String acc_no) {
		System.out.println("Checking account number "+acc_no);
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Account where account_no=:account_no");
		query.setParameter("account_no", acc_no);
		List<Account> account = query.list();
		session.getTransaction().commit();
		session.close();
		if(account.size()<=0) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean transferAmount(String from_account_no, String to_account_no, double amount) {
		System.out.println("Transfering amount ");
		session =  factory.openSession();
		session.beginTransaction();
		
		Account to_account = getAccount(to_account_no);
		Account from_account = getAccount(from_account_no);
		double from_prev_bal = from_account.getBalance();
		
		double to_balance = to_account.getBalance();
		if(amount>to_balance) {
			session.getTransaction().rollback();
			return false;
			
		}
		
		double from_updatedAmount = from_account.getBalance()-amount;
		Query query1 = session.createQuery("update Account set balance = :amount" +" where account_no = :account_no");
		query1.setParameter("amount", from_updatedAmount);
		query1.setParameter("account_no", from_account_no);
		int from_result = query1.executeUpdate();
		
		
		double to_updatedAmount = to_account.getBalance()+amount;
		Query query = session.createQuery("update Account set balance = :amount" +" where account_no = :account_no");
		query.setParameter("amount", to_updatedAmount);
		query.setParameter("account_no", to_account_no);
		int result = query.executeUpdate();
		
		Transaction t1 = new Transaction(UUID.randomUUID().getMostSignificantBits()+"", "Transfer", new Date(), amount, from_updatedAmount, from_prev_bal, to_account_no);
	
		addTransaction(t1);
		this.userRepo.seTransaction(t1, from_account, session);
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Transfer successfull "+result);
		return true;
	}
	
	public Account getAccount(String to_account_no) {
		Query query = session.createQuery("from Account where account_no=:account_no");
		query.setParameter("account_no", to_account_no);
		List<Account> account = query.list();
		return account.get(0);
	}
	
	public void addTransaction(Transaction t) {
		session.save(t);
	}
	
	public boolean depositAmount(String account_no,double amount) {
		session = factory.openSession();
		session.beginTransaction();
		Account account = getAccount(account_no);
		double previousBal = account.getBalance();
		double updatedBal = previousBal+amount;
		System.out.println("depositing amount to "+account_no);
		Query query = session.createQuery("update Account set balance = :amount" +" where account_no = :account_no");
		query.setParameter("amount", updatedBal);
		query.setParameter("account_no", account_no);
		int result = query.executeUpdate();
		
		Transaction t = new Transaction(UUID.randomUUID().getMostSignificantBits()+"", "Deposit", new Date(), amount, updatedBal,previousBal, account_no);
		addTransaction(t);
		
		this.userRepo.seTransaction(t, account, session);
		session.getTransaction().commit();
		session.close();
		return true;
	}
	
	public boolean withDraw(String acc_no, double amount) {
		session = factory.openSession();
		session.beginTransaction();
		Account account = getAccount(acc_no);
		
		double previousBal = account.getBalance();
		if(previousBal <=1000) {
			return false;
		} else if((previousBal-amount) <= 1000) {
			return false;
		}
		
		double updatedBal = previousBal-amount;
		System.out.println("depositing amount to "+acc_no);
		Query query = session.createQuery("update Account set balance = :amount" +" where account_no = :account_no");
		query.setParameter("amount", updatedBal);
		query.setParameter("account_no", acc_no);
		int result = query.executeUpdate();
		
		Transaction t = new Transaction(UUID.randomUUID().getMostSignificantBits()+"", "Withdraw", new Date(), amount, updatedBal,previousBal,  acc_no);
		addTransaction(t);
		
		this.userRepo.seTransaction(t, account, session);
		
		session.getTransaction().commit();
		session.close();
		return true;
	}
	
	public void lockAccount(String acc_no) {
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("update Account set activated = :activated"+" where account_no=:account_no");
		query.setParameter("activated", false);
		query.setParameter("account_no", acc_no);
		int result = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		
		System.out.println("deactivated "+result);
	}
}
