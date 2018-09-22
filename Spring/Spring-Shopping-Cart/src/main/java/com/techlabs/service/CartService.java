package com.techlabs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.entity.Cart;
import com.techlabs.entity.LineItem;
import com.techlabs.repository.CartRepo;

@Service
public class CartService {
	private CartRepo cartRepo = null;
	private List<Cart> cartProducts;
	
	@Autowired
	public void setCartRepo(CartRepo repo) {
		this.cartRepo = repo;
	}
	
	public CartService() {
		cartProducts = new ArrayList<Cart>();
	}
	
	public void addToCart(Cart cart, String email) {
		this.cartProducts.add(cart);
		this.cartRepo.addToCart(cart, email);
	}

	public List<Cart> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(List<Cart> cartProducts) {
		this.cartProducts = cartProducts;
	}
	
	public boolean isAlreadyInCart(String id) {
		for(Cart item: this.cartProducts) {
			if(id.equals(item.getProduct().getProduct_id())){
				return true;
			}
		}
		return false;
	}
	
}
