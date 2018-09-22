package com.techlabs.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.entity.Cart;
import com.techlabs.entity.Customer;
import com.techlabs.repository.CartRepo;
import com.techlabs.repository.CustomerRepository;

@Service
public class CustomerService {
	private CartRepo cartRepo = null;
	private List<Cart> cartItems = null;
	private CustomerRepository customerRepo = null;
	
	@Autowired
	public void setCartRepo(CartRepo repo, CustomerRepository cRepo) {
		this.cartRepo = repo;
		this.customerRepo = cRepo;
	}
	
	public CustomerService() {
		this.cartItems = new ArrayList<>();
	}
	
	public List<Cart> getCartItemsById(String customerId) {
	
		return this.cartRepo.getCartItemsById(customerId);
	}
	
	public String getIdByEmail(String email) {
		System.out.println("From customer service "+email);
		return this.customerRepo.getIdByEmail(email);
	}
	
	public Customer getCustomerByEmail(String email) {
		Customer customer = null;
		customer = this.customerRepo.getCustomerByEmail(email);
		return customer;
	}
	
	public void saveCustomer(Customer c) {
		this.customerRepo.addUser(c);
	}
		
}
