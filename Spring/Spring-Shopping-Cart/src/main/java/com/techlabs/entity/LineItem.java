package com.techlabs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="LineItem")
public class LineItem {
	
	@Id
	@Column(name="lineitem_id")
	private String lineItem_id;
	
	@Column(name="quantity")
	private int quantity;
		
	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	public LineItem() {}
	
	public LineItem(String id, int quantity, Order order, Product product) {
		this.lineItem_id = id;
		this.quantity = quantity;
		this.order = order;
		this.product =  product;
	}

	public String getLineItem_id() {
		return lineItem_id;
	}

	public void setLineItem_id(String lineItem_id) {
		this.lineItem_id = lineItem_id;
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
}
