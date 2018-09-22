package com.banking.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class Account {
	
	@Id
	@Column(name="account_no")
	private String account_no;
	
	@Column(name="type")
	private String account_type;
	
	@Column(name="balance")
	private double balance;
	
	@Column(name="activated")
	private boolean activated;
	
	@OneToOne
	@JoinColumn(name = "account_no")
	@MapsId
	private User user;
	
	public Account() {}
	
	public Account(String type, double balance) {
		//this.account_no = acc_no;
		this.balance = balance;
		this.account_type = type;
		this.activated = false;
	}

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}
}	
