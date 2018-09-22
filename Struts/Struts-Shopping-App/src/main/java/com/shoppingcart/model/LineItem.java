package com.shoppingcart.model;

public class LineItem {
	private String lineItem_id;
	private int quantity;
	private String order_id;
	private String product_id;
	
	public LineItem() {}
	
	public LineItem(String id, int quantity, String order_id, String product_id) {
		this.lineItem_id = id;
		this.quantity = quantity;
		this.order_id = order_id;
		this.product_id =  product_id;
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

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
}
