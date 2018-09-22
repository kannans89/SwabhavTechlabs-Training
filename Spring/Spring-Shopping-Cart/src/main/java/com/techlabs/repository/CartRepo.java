package com.techlabs.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techlabs.entity.Cart;
import com.techlabs.service.CustomerService;

@Repository
public class CartRepo {
	private SessionFactory factory = null;
	
	private Session session;
	private CustomerService customerService = null;
	
	@Autowired
	public void setFactory(SessionFactory factory, CustomerService service) {
		this.factory = factory;
		this.customerService = service;
	}
	
	public CartRepo() {
	}
	
	public void addToCart(Cart cart, String email) {
//		this.cartProducts.add(cart);
		session = factory.openSession();
		session.beginTransaction();
		session.save(cart);
		session.getTransaction().commit();
		session.close();
	}

	public List<Cart> getCartItemsById(String email) {
		System.out.println("Inside get cart items by id ");
		List<Cart> cartItems = new ArrayList<>();
		String cust_id = this.customerService.getIdByEmail(email);
		System.out.println("in cart repo\n"+email+"\t"+cust_id+"\n");
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Cart where cust_id = :cust_id");
		query.setParameter("cust_id", cust_id);
		cartItems = query.list();
		session.getTransaction().commit();
		session.close();
		System.out.println("Found cart item list size is "+cartItems.size());
		return cartItems;
	}
}
