package com.techlabs.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.techlabs.entity.Actor;
import com.techlabs.entity.Movie;
import com.techlabs.utilities.HibernateUtilities;

public class Test {
	public static void main(String[] args) {
		HibernateUtilities hbutilities = new HibernateUtilities();
		SessionFactory factory = hbutilities.getSessionFactory();
		Session hbsession = factory.openSession();
		
		Set<Movie> moviesSet = new HashSet<>();
		
		Movie movie1 = new Movie(101, "Sanju", 50000);
		
		Actor actor1 = new Actor(1001, "abc");
		moviesSet.add(movie1);
		actor1.setMovies(moviesSet);
		
		hbsession.beginTransaction();
		hbsession.save(actor1);
		hbsession.save(movie1);
		
		hbsession.getTransaction().commit();
	}
}
