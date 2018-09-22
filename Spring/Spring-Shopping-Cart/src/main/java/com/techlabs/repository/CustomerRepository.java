package com.techlabs.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techlabs.entity.Customer;

@Repository
public class CustomerRepository {
	private SessionFactory factory = null;
	private Session session = null;
	private List<Customer> customers = null;

	public CustomerRepository() {
		this.customers = new ArrayList<>();
	}

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public List<Customer> getUsers() {
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Customer");
		List<Customer> customers = query.list();
		session.getTransaction().commit();
		session.close();
		return customers;
	}

	public void setUsers(List<Customer> users) {
		this.customers = users;
	}

	public void addUser(Customer user) {
		session = factory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

	public boolean findUser(String email, String password) {
		System.out.println("Inside user repo finduser");
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Customer");
		this.customers = query.list();
		session.getTransaction().commit();
		session.close();

		for (Customer customer : customers) {
			if (customer.getEmail().equals(email)) {
				if (customer.getPassword().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}

	public String getIdByEmail(String email) {
		this.customers = getUsers();
		System.out.println("Number of users "+customers.size());
		for (Customer c : customers) {
			
			System.out.println("in customer repo\n"+c.getEmail()+"\t"+c.getCust_id());
			if (c.getEmail().equals(email)) {
				return c.getCust_id() + "";

			}
		}
		return "";
	}
	
	public Customer getCustomerByEmail(String email) {
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Customer");
		this.customers = query.list();
		session.getTransaction().commit();
		session.close();
		
		for(Customer customer: customers) {
			if(customer.getEmail().equals(email)) {
				System.out.println("Found customer with email "+email);
				return customer;
			}
		}
		return null;
	}
}
