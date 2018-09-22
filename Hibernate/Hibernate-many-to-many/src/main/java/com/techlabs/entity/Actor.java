package com.techlabs.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "Actor")
public class Actor {

	@Id
	@Column(name = "Actor_id", nullable = false)
	private int id;

	@Column(name = "Name")
	private String name;

	@ManyToMany(targetEntity = Movie.class, cascade = { CascadeType.ALL })

	@JoinTable(name = "actor_movies", joinColumns = { @JoinColumn(name = "Actor_id") }, inverseJoinColumns = {
			@JoinColumn(name = "Movie_id") })
	private Set<Movie> movies;
	
	public Actor() {}
	
	public Actor(int id, String name) {
		this.id = id;
		this.name = name;
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

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}
}
