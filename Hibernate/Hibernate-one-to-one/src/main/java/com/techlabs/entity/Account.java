package com.techlabs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Account {
	
	@Column(name="id")
	private int id;
	
	@Id
	@Column(name="Acc_no")
	private int acc_no;
	
	@Column(name="Type")
	private String type;
	
	@OneToOne(mappedBy="account")
	private Customer customer;
	
	public Account() {}
	
	public Account(int id, int acc_no, String type) {
		this.id = id;
		this.acc_no = acc_no;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
