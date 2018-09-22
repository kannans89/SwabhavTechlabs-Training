package com.banking.repo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.banking.entity.Account;
import com.banking.entity.Transaction;
import com.banking.entity.User;

@Repository
public class UserRepo {
	private SessionFactory factory = null;
	private Session session = null;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public void addUser(User user) {
		session = factory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

	public String getAccountNumberByEmail(String email) {
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User where email=:email");
		query.setParameter("email", email);
		List<User> user = query.list();
		session.getTransaction().commit();
		session.close();
		return user.get(0).getAccount_no();
	}

	public User findUser(String email, String password) {
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User where email=:email");
		query.setParameter("email", email);
		List<User> user = query.list();
		session.getTransaction().commit();
		session.close();

		System.out.println("Found user " + user.get(0).getEmail());
		return user.get(0);
	}

	public void seTransaction(Transaction t, Account account, Session session) {
		User user = getUser(account.getAccount_no(), session);
		Set<Transaction> transactions = new HashSet<>();
		transactions.add(t);
		user.setTransactions(transactions);
		t.setUser(user);
	}

	public User getUser(String account_no, Session session) {
		Query query = session.createQuery("from User where account_no=:account_no");
		query.setParameter("account_no", account_no);
		List<User> user = query.list();
		return user.get(0);
	}

	public boolean isEmailPresent(String email) {
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User where email =:email");
		query.setParameter("email", email);
		List<User> users = query.list();
		session.getTransaction().commit();
		session.close();
		if (users.size() > 0) {
			System.out.println("Email already present");
			return false;
		}
		return true;
	}

	public boolean checkRole(String email, String password) {
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User where email=:email and password=:password");
		query.setParameter("email", email);
		query.setParameter("password", password);
		List<User> users = query.list();
		
		session.getTransaction().commit();
		session.close();

		if (users.get(0).getRole().equals("admin")) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<User> getUsers(){
		session = factory.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from User");
		List<User> users = q.list();
		session.getTransaction().commit();
		session.close();
		return users;
	}
}
