package com.techlabs.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techlabs.entity.User;

@Repository
public class UserRepository {
	private SessionFactory factory = null;
	private Session session = null;
	private List<User> users = null;
	
	public UserRepository() {
		this.users = new ArrayList<>();
	}
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public void addUser(User user) {
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
		Query query = session.createQuery("from User");
		this.users = query.list();
		session.getTransaction().commit();
		session.close();
		
		for(User user: users) {
			if(user.getEmail().equals(email)){
				if(user.getPassword().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}
}
