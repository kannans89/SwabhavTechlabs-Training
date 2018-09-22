package com.techlabs.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {

	@Id
	@Column(name="product_id", nullable = false)
	private String product_id;
	
	@Column(name="product_name", nullable = false)
	private String product_name;
	
	@Column(name="cost", nullable = false)
	private double cost;
	
	@Column(name="discount", nullable = false)
	private double discount;
	
	@OneToMany(mappedBy="product")
	private Set<LineItem> lineItems = new HashSet<>();

	public Set<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(Set<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	
	public Product() {}

	public Product(String id, String name, double cost, double discount){
		this.product_id = id;
		this.product_name = name;
		this.cost = cost;
		this.discount = discount;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
}
