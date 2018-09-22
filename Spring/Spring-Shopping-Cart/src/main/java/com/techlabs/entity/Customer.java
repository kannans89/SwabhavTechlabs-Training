package com.techlabs.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Customers")
public class Customer {

	@Id
	@Column(name="cust_id", nullable = false)
	private long cust_id;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Order> order = new HashSet<Order>();

	@OneToMany(mappedBy="customer")
	private Set<Cart> cartProducts = new HashSet<>();
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	public Customer() {}
	public Customer(long cust_id, String first_name, String last_name, String email, String password) {
		super();
		this.cust_id = cust_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
	}

	public long getCust_id() {
		return cust_id;
		
	}

	public void setCust_id(long cust_id) {
		this.cust_id = cust_id;
	}

	public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Cart> getCartProducts() {
		return cartProducts;
	}
	public void setCartProducts(Set<Cart> cartProducts) {
		this.cartProducts = cartProducts;
	}
		
}
