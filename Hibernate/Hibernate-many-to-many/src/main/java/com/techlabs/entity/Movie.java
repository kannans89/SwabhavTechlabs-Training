package com.techlabs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Movies")
public class Movie {

	@Id
	@Column(name="ID")
	private int id;

	@Column(name="Name")
	private String name;
	
	@Column(name="Budget")
	private double budget;
	
	public Movie() {}
	public Movie(int id, String name, double budget) {
		this.id = id;
		this.name = name;
		this.budget = budget;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	
	
}
