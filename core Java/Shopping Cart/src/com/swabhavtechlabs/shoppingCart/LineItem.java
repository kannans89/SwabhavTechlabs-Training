package com.swabhavtechlabs.shoppingCart;

public class LineItem {
	private int quantity;
	private String lineItemID;
	Product product;
	
	public LineItem(int quantity, String lineItemID, Product product) {
		this.quantity = quantity;
		this.lineItemID = lineItemID;
		this.product = product;
	}
	
	public double totalCost() {
		return product.calculatePrice()*this.quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getLineItemID() {
		return lineItemID;
	}

	public Product getProduct() {
		return product;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setLineItemID(String lineItemID) {
		this.lineItemID = lineItemID;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
