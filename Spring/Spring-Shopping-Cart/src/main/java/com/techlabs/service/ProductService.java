package com.techlabs.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.entity.Product;
import com.techlabs.repository.ProductRepository;

@Service
public class ProductService {
	private List<Product> products = null;
	private static ProductService productInstance = null;
	private ProductRepository productRepo = null;

	@Autowired
	public void setProductRepo(ProductRepository repo) {
		this.productRepo = repo;
	}

	private ProductService() {
		System.out.println("Product Service created");
		products = new ArrayList<>();
	}

	public static ProductService getInstance() {
		if (productInstance == null) {
			productInstance = new ProductService();
			return productInstance;
		}
		return productInstance;
	}

	public List<Product> getProducts() {
		return this.productRepo.getProducts();
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Map<String, String> getProductsNameValuePair() {
		System.out.println("inside get product name "+products.size());
		Map<String, String> keyValProducts = new HashMap<>();
		this.products = this.productRepo.getProducts();
		
		for (Product product : this.products) {
			keyValProducts.put(product.getProduct_id(), product.getProduct_name());
		}
		return keyValProducts;
	}

	public Product getProductById(String id) {
		this.products = this.productRepo.getProducts();
		for (Product p : products) {
			if (p.getProduct_id().equals(id)) {
				return p;
			}
		}
		return null;
	}
}
