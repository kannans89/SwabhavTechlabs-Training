package com.shoppingcart.service;

import java.util.ArrayList;
import java.util.List;

import com.shoppingcart.model.LineItem;
import com.shoppingcart.model.Product;

public class LineItemService {
	private List<LineItem> lineItems = null;
	
	public LineItemService() {
		lineItems = new ArrayList<>();
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	
	public void addLineItem(LineItem lineItem) {
		this.lineItems.add(lineItem);
//		for(LineItem item:lineItems) {
//			System.out.println(item.getLineItem_id()+" "+item.getProduct_id());
//		}
		
	}
	
	public boolean isAlreadyInCart(String id) {
		for(LineItem item: this.lineItems) {
			if(id.equals(item.getProduct_id())){
				return true;
			}
		}
		return false;
	}
	
	public LineItem getLineItemById(String id) {
		for(LineItem item: this.lineItems) {
			if(id.equals(item.getProduct_id())) {
				return item;
			}
		}
		return null;
	}
	
	public void updateLineItem(LineItem updatedItem) {
		for(LineItem item: this.lineItems) {
			if(updatedItem.getProduct_id().equals(item.getProduct_id())) {
				this.lineItems.remove(item);
				this.lineItems.add(updatedItem);
			}
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
