package com.techlabs.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.techlabs.entity.Account;
import com.techlabs.entity.Customer;
import com.techlabs.utilities.HibernateUtilities;

public class Test {
	public static void main(String[] args) {
		HibernateUtilities hbutilities = new HibernateUtilities();
		SessionFactory factory = hbutilities.getSessionFactory();
		Session hbsession = factory.openSession();
		
		Customer customer = new Customer(101, "manoj", "Virar");
		
		Account account = new Account(1001, 123456, "Savings");
		
		account.setCustomer(customer);
		customer.setAccount(account);
		
		hbsession.beginTransaction();
		
		hbsession.save(account);
		hbsession.save(customer);
		hbsession.getTransaction().commit();
		
		//seslectCustomer(hbsession,1001);
	}
	
	public static void seslectCustomer(Session session, int id) {
		session.beginTransaction();
		Query q = session.createQuery("from Account where id=1001");
		Account account1 = (Account) q.uniqueResult();
		session.getTransaction().commit();
		session.close();
		
		System.out.println(account1.getId());
	}
}
