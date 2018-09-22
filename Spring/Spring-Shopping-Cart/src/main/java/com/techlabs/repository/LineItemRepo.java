package com.techlabs.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techlabs.entity.LineItem;

@Repository
public class LineItemRepo {
	private SessionFactory factory = null;
	private List<LineItem> lineitems = null;
	private Session session = null;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	public LineItemRepo() {
		this.lineitems = new ArrayList<>();
	}

	public List<LineItem> getLineitems() {
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from LineItem");
		this.lineitems = query.list();
		session.getTransaction().commit();
		session.close();
		System.out.println("from get line items "+this.lineitems.size());
		return this.lineitems;
	}

	public void setLineitems(List<LineItem> lineitems) {
		this.lineitems = lineitems;
	}
	
	public void addLineItem(LineItem item) {
		session = factory.openSession();
		session.beginTransaction();
		session.save(item);
		session.getTransaction().commit();
		session.close();
	}
}
