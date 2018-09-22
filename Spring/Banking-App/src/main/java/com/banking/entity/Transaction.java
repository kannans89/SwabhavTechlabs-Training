package com.banking.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Transaction")
public class Transaction {
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="receiver")
	private String receiver;
	
	@Column(name="prevBalance")
	private double prevBalance;
	
	@Column(name="balance")
	private double newBalance;
	
	@ManyToOne
	@JoinColumn(name="account_no")
	private User user;
	
	public Transaction() {}

	public Transaction(String id, String type, Date date, double amount, double newBalance, double prevBalance, String receiver) {
		super();
		this.id = id;
		this.type = type;
		this.date = date;
		this.amount = amount;
		this.receiver = receiver;
		this.newBalance = newBalance;
		this.prevBalance = prevBalance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public double getPrevBalance() {
		return prevBalance;
	}

	public void setPrevBalance(double prevBalance) {
		this.prevBalance = prevBalance;
	}

	public double getNewBalance() {
		return newBalance;
	}

	public void setNewBalance(double newBalance) {
		this.newBalance = newBalance;
	}
}

