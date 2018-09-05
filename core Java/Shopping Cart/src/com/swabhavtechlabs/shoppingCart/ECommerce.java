package com.swabhavtechlabs.shoppingCart;

import java.util.ArrayList;
import java.util.List;

public class ECommerce {
	List<Customer> customers;
	
	public ECommerce() {
		customers = new ArrayList<>();
	}
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	
	public List<Customer> getCustomers(){
		return this.customers;
	}
	
	public boolean checkIfCustomerIsUnique(int id){
		for(Customer customer: customers) {
			if(customer.getCustomerID() == id)
				return false;
		}
		return true;
	}
}
