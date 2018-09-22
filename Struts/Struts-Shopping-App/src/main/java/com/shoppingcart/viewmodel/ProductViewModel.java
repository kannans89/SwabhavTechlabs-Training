package com.shoppingcart.viewmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.shoppingcart.model.LineItem;
import com.shoppingcart.model.Product;
import com.shoppingcart.model.LineItem;

import java.util.Map.Entry;

public class ProductViewModel {
	private String product_id;
	private String name;
	private double cost;
	private double discount;
	private int quantity;

	private int updatedQuantity;
	private String updated_lineitem_id;

	private Map<String, String> productNameValue = null;
	private Map<LineItem, Product> cartProduct = null;

	public ProductViewModel() {
		productNameValue = new HashMap<>();
		cartProduct = new HashMap<>();
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Map<String, String> getProductNameValue() {
		return productNameValue;
	}

	public void setProductNameValue(Map<String, String> productNameValue) {

		this.productNameValue = productNameValue;
	}

	public Map<LineItem, Product> getCartProduct() {
		return cartProduct;
	}

	public void setCartProduct(Map<LineItem, Product> cartProduct) {
		System.out.println("inside set cart product " + cartProduct.size());

		this.cartProduct = cartProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUpdatedQuantity() {
		return updatedQuantity;
	}

	public void setUpdatedQuantity(int updatedQuantity) {
		this.updatedQuantity = updatedQuantity;
	}

	public String getUpdated_lineitem_id() {
		return updated_lineitem_id;
	}

	public void setUpdated_lineitem_id(String updated_lineitem_id) {
		this.updated_lineitem_id = updated_lineitem_id;
	}
}