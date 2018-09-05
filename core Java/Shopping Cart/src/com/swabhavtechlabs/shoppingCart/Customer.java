package com.swabhavtechlabs.shoppingCart;

import java.util.HashMap;

public class Customer {
	private String name;
	private String address;
	private String contactNumber;
	private int customerID;
	private HashMap<String, Order> orders;
	
	public Customer(int id, String name, String address, String contactNumber) {
		this.name = name;
		this.address = address;
		this.contactNumber = contactNumber;
		this.customerID = id;
		this.orders = new HashMap<>();
	}
	
	public Customer() {}
	public boolean placeOrder(Order order) {
		orders.put("101", order);
		return true;
	}
	
	public boolean cancelOrder(String orderID) {
		return true;
	}
	
	public HashMap<String, Order> getOrderList(){
		return this.orders;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public void setOrders(HashMap<String, Order> lineItems) {
		this.orders = orders;
	}
}
