package com.techlabs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.entity.LineItem;
import com.techlabs.repository.LineItemRepo;

@Service
public class LineItemService {
	private List<LineItem> lineItems = null;
	private LineItemRepo lineItemRepo = null;
	
	@Autowired
	public void setLineItemRepo(LineItemRepo repo) {
		this.lineItemRepo = repo;
	}
	
	public LineItemService() {
		System.out.println("Lineietem service created");
		lineItems = new ArrayList<>();
	}

	public List<LineItem> getLineItems() {
		this.lineItems = this.lineItemRepo.getLineitems();
		return this.lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	
	public void addLineItem(LineItem lineItem) {
		this.lineItemRepo.addLineItem(lineItem);
//		this.lineItems.add(lineItem);
		
	}
	
	public boolean isAlreadyInCart(String id) {
		for(LineItem item: this.lineItems) {
//			if(id.equals(item.getProduct_id())){
//				return true;
//			}
		}
		return false;
	}
	
	public LineItem getLineItemById(String id) {
		for(LineItem item: this.lineItems) {
//			if(id.equals(item.getProduct_id())) {
//				return item;
//			}
		}
		return null;
	}
	
	public void updateLineItem(LineItem updatedItem) {
		for(LineItem item: this.lineItems) {
//			if(updatedItem.getProduct_id().equals(item.getProduct_id())) {
//				this.lineItems.remove(item);
//				this.lineItems.add(updatedItem);
//			}
		}
	}
	
	public List<LineItem> removeElementById(String id){
		System.out.println("Inside remove element by id");
		LineItem foundItem = new LineItem();
		for(LineItem item: lineItems) {
			if(id.equals(item.getLineItem_id())) {
				System.out.println("Item found "+item.getLineItem_id());
				foundItem = item;
				break;
			}
		}
		this.lineItems.remove(foundItem);
		return this.lineItems;
	}
}
