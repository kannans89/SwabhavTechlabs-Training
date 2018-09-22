package com.techlabs.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "NewOrders")
public class Order {

	@Id
	@Column(name = "order_id", nullable = false)
	private long order_id;

	@Column(name = "order_date", nullable = false)
	private String date;

	@ManyToOne
	@JoinColumn(name = "cust_id", nullable = false)
	private Customer customer;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private Set<LineItem> lineitems = new HashSet<LineItem>();

	public Order() {}
	
	public Order(long l, String date, Customer customer) {
		super();
		this.order_id = l;
		this.date = date;
		this.customer = customer;
	}

	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Set<LineItem> getLineitems() {
		return lineitems;
	}

	public void setLineitems(Set<LineItem> lineitems) {
		this.lineitems = lineitems;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
