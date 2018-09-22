package com.techlabs.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fasterxml.uuid.Generators;
import com.techlabs.entity.Customer;
import com.techlabs.entity.LineItem;
import com.techlabs.entity.Order;
import com.techlabs.entity.Product;

public class EntityTest {

	public static void main(String args[]) {
		Date date = new Date();
		SimpleDateFormat convert = new SimpleDateFormat("dd/MM/YYYY HH:MM:SS ");

		Customer cust = new Customer(Math.abs(UUID.randomUUID().getMostSignificantBits()), "Manoj", "virar");
		Product product = new Product();
		
		Set<Order> orderset = new HashSet<Order>();
		Order order1 = new Order(Math.abs(UUID.randomUUID().getMostSignificantBits()), convert.format(date), cust);
		Order order2 = new Order(Math.abs(UUID.randomUUID().getMostSignificantBits()), convert.format(date), cust);
		
		Product product1 = null;
		orderset.add(order1);
		orderset.add(order2);
		
		cust.setOrder(orderset);
		
		product1 = new Product(Math.abs(UUID.randomUUID().getMostSignificantBits()), "Laptop", 30000, 5);

		Set<LineItem> lineItemSet1 = new HashSet<>();
		LineItem lineItem1 = new LineItem(Math.abs(UUID.randomUUID().getMostSignificantBits()),5, product1, order1);
		Set<LineItem> lineItemSet2 = new HashSet<>();
		LineItem lineItem2 = new LineItem(Math.abs(UUID.randomUUID().getMostSignificantBits()), 3, product1, order2);

		lineItemSet1.add(lineItem1);
		lineItemSet2.add(lineItem2);
		
		order1.setLineitems(lineItemSet1);
		order2.setLineitems(lineItemSet2);
		
		Set<LineItem> productSet = new HashSet<>();
		productSet.add(lineItem1);
		productSet.add(lineItem2);
		
		product.setLineItems(productSet);
		
		
		try {
			Configuration config = new Configuration();
			config.configure("hibernate-cfg.xml");
			SessionFactory factory = config.buildSessionFactory();
			Session hbsession = factory.getCurrentSession();

			
			hbsession.beginTransaction();
			hbsession.save(cust);
			hbsession.save(product1);
			
			
			hbsession.save(lineItem1);
			hbsession.save(lineItem2);
			
			
			hbsession.save(order1);
			hbsession.save(order2);

		
			hbsession.getTransaction().commit();
			factory.close();
		} catch (Exception ex) {
			System.out.println("from entity test "+ex.getMessage());
		}
		
		System.out.println(cust.getCust_id());

	}
}
