package com.techlabs.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	
	@Id
	@Column(name="cart_id")
	private String cart_id;
	
	@Column(name="quantity")
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@ManyToOne()
	@JoinColumn(name="cust_id")
	private Customer customer;
	
	public Cart() {}
	
	public Cart(String id, int quantiy, Product product, Customer customer) {
		this.cart_id = id;
		this.quantity = quantiy;
		this.product = product;
		this.customer = customer;
	}

	public String getcartId() {
		return cart_id;
	}

	public void setcartId(String id) {
		this.cart_id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getCart_id() {
		return cart_id;
	}

	public void setCart_id(String cart_id) {
		this.cart_id = cart_id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
