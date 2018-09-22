package com.techlabs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;


import com.techlabs.entity.*;
@Entity
public class LineItem {
	
	@Id
	@Column(name="lineitem_id", nullable = false)
	private long id;
	
	@Column(name="quantity", nullable = false)
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public LineItem() {}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}


	public LineItem(long id, int quantity, Product product, Order order) {
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.order = order;
	}
	
	public LineItem(int id, int quantity) {
		this.id = id;
		this.quantity = quantity;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}

}
