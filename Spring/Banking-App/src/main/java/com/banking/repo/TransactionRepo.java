package com.banking.repo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.banking.entity.Transaction;
import com.mysql.jdbc.DatabaseMetaData;

@Repository
public class TransactionRepo {
	SessionFactory factory = null;
	Session session = null;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	public List<Transaction> getTransactions(String account_no){
		System.out.println("Finding transaction of "+account_no);
		session = factory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Transaction where account_no=:account_no");
		query.setParameter("account_no", account_no);
		List<Transaction> transactions = query.list();
		session.getTransaction().commit();
		session.close();
		System.out.println("NUmber of transaction "+transactions.size());
		return transactions;
	}
}
