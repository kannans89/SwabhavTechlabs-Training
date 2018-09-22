package com.shoppingcart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.shoppingcart.model.Product;

public class ProductService {
	private List<Product> products = null; 
	private List<Product> cartProducts = null;
	private static ProductService productInstance = null;
	
	private ProductService() {
		products = new ArrayList<>();
		createProducts();
	}
	
	private void createProducts() {
		products.add(new Product("p101", "Macbook Pro", 100000, 10));
		products.add(new Product("p102", "Dell XPS", 75000, 10));
		products.add(new Product("p103", "Iphone 8", 50000, 10));
	}
	
	public static ProductService getInstance() {
		if(productInstance==null) {
			productInstance = new ProductService();
			return productInstance;
		}
		return productInstance;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public Map<String, String> getProductsNameValuePair(){
//		System.out.println("inside get product name "+products.size());
		Map<String, String> keyValProducts = new HashMap<>();
		
		for(Product product: products) {
			keyValProducts.put(product.getId(), product.getName());
		}
//		System.out.println(keyValProducts.size());
		return keyValProducts;
	}
	
	public Product getProductById(String id) {
		for(Product p: products) {
			if(p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}
}
