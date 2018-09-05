package com.swabhavtechlabs.shoppingCart;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ShoppingMenu {
	public static Product createProduct() {
		String nameOfProduct = "Watch";
		String productID = "watch101";
		double actualCost = 1500;
		double discount = 10;
		
		return new Product(nameOfProduct, productID, actualCost, discount);
	}
	
	public static Order createOrder(Product newProduct) {
		Product product = newProduct;
		String orderID = "watch101";
		Date date = new Date();
		LineItem lineItem = new LineItem(1, "101", product);
		return new Order(orderID, date, lineItem);
	}
	
	public static void displayCustomers(List<Customer> customers) {
		System.out.println(customers.size());
		for(Customer customer: customers) {
			System.out.println(customer.getName()+"\t"+customer.getCustomerID());
		}
	}
	
	public static void displayOrders(int id, List<Customer> customers) {
		System.out.println("Name\tCustomer ID\tContact Number\tAddress");
		System.out.println("---------------------------------------------------------");
		for(Customer customer: customers) {
			if(customer.getCustomerID() == id) {
				System.out.print(customer.getName()+"\t");
				System.out.print(customer.getCustomerID()+"\t");
				System.out.print(customer.getContactNumber()+"\t");
				System.out.print(customer.getAddress()+"\t");
				System.out.println();
				System.out.println();
				System.out.println("Orders List( "+customer.getOrderList().size()+")");
				System.out.println();
				Set<Map.Entry<String, Order>> set = customer.getOrderList().entrySet();
				for(Map.Entry<String, Order> entries: set) {
					System.out.print(entries.getKey()+"--->\t");
					System.out.print("\t"+entries.getValue().getLineItem().get(0).getLineItemID()+"\n");
					System.out.print("\t\t"+entries.getValue().getLineItem().get(0).getQuantity()+"\n");
					System.out.print("\t\t"+entries.getValue().getLineItem().get(0).getProduct().getName()+"\n");
					System.out.print("\t\t"+entries.getValue().getLineItem().get(0).getProduct().getActualCost()+"\n");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int value, choice;
		Scanner sc = new Scanner(System.in);
		Customer customer = new Customer();
		ECommerce ecommerce = new ECommerce();
		
		do{
			System.out.println("1.Place order\n2.Cancel order\n3.Display order history\n4.Display customers");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					System.out.println("Enter your customer id");
					int id = sc.nextInt();
					if(ecommerce.checkIfCustomerIsUnique(id)) {
						System.out.println("If you are a new Customer please enter following details.");
						customer = new Customer(111, "Manoj", "Virar", "7276234147");
						ecommerce.addCustomer(customer);
						System.out.println("Customer created...");
					}
				Product product = createProduct();
				Order order = createOrder(product);
				customer.placeOrder(order);
				System.out.println("Placed order successfully");
				break;
				
				case 3:
					System.out.println("Enter your customer id");
					id = sc.nextInt();
					displayOrders(id, ecommerce.getCustomers());
					System.out.println("Done!");
					break;
					
				case 4:
					displayCustomers(ecommerce.getCustomers());
					break;
			}
			
			System.out.println("Want to continue? 1/0");
			value = sc.nextInt();
		}while(value!=0);

	}

}
