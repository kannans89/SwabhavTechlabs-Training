package com.techlabs.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techlabs.entity.Product;

@Repository
public class ProductRepository {
	private SessionFactory factory = null;
	private List<Product> products = null;
	private Session session = null;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	public ProductRepository() {
		this.products = new ArrayList<>();
	}
			
	public List<Product> getProducts(){
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Product");
		this.products = query.list();
		session.getTransaction().commit();
		session.close();
		
//		System.out.println("From product service size of the list "+this.products.size());
		return this.products;
	}
}
