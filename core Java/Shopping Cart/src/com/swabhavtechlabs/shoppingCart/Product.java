package com.swabhavtechlabs.shoppingCart;

public class Product {
	private String name;
	private String productID;
	private double actualCost, discount;
	
	public Product(String name, String id, double actualCost, double discountPercent) {
		this.name = name;
		this.productID = id;
		this.actualCost = actualCost;
		this.discount = discountPercent;
	}
	
	public double calculatePrice() {
		double discount =  (this.discount/100)*actualCost;
		return (this.actualCost - discount);
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return productID;
	}

	public double getActualCost() {
		return actualCost;
	}

	public double getDiscountInPercent() {
		return discount;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.productID = id;
	}

	public void setActualCost(double actualCost) {
		this.actualCost = actualCost;
	}

	public void setDiscountInPercent(double discountInPercent) {
		this.discount = discountInPercent;
	}
}
