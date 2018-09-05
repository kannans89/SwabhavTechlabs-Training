package com.swabhavtechlabs.shoppingCart;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Order {
	private String orderID;
	private List<LineItem> lineItems;
	private Date date;
	
	
	public Order(String id, Date date, LineItem lineItem) {
		lineItems = new ArrayList<>();
		this.orderID = id;
		this.date = date;
		this.lineItems.add(lineItem);
	}
	
	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public List<LineItem> getLineItem() {
		return lineItems;
	}

	public Date getDate() {
		return date;
	}

	public void setLineItem(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
