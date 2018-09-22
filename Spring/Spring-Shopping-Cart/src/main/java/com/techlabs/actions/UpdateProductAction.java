package com.techlabs.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.entity.LineItem;
import com.techlabs.service.LineItemService;

public class UpdateProductAction extends ActionSupport{
	private int quantity;
	private String lId;
	private String data;
	private List<LineItem> lineitems = null;
	private LineItemService service = null;
	public UpdateProductAction() {
		lineitems = new ArrayList<LineItem>();
		service = new LineItemService();
	}
	
	public String execute() {
		Map<String, Object> session=  ServletActionContext.getContext().getSession();

		lineitems = (List<LineItem>) session.get("lineitems");
		session.put("lineitems", updateLineItem(lineitems, getlId(), getQuantity()));
		return SUCCESS;
	}	
	
	public List<LineItem> updateLineItem(List<LineItem> items, String id, int q) {
		List<LineItem> updatedLineItems = new ArrayList<>();
		updatedLineItems = items;
		int i = -1;
		
		for(LineItem item1: items) {
			i++;
			System.out.println("id is"+id);
			System.out.println("another is "+item1.getLineItem_id());
			if(item1.getLineItem_id().equals(id)) {
				System.out.println("Id found");
				item1.setQuantity(q);
				
				break;
			}
		}
		System.out.println("Value of i is "+i+" and "+updatedLineItems.get(i).getQuantity());
		return updatedLineItems;
		
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getlId() {
		return lId;
	}

	public void setlId(String lineId) {
		this.lId = lineId;
	}

	public String getdata() {
		System.out.println("Inside get data");
		return this.data;
	}
	
	public void setdata(String data) {
		this.data = data;
	}
}
