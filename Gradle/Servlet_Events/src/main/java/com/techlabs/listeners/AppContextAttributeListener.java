package com.techlabs.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * Application Lifecycle Listener implementation class AppContextAttributeListener
 *
 */
public class AppContextAttributeListener implements ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public AppContextAttributeListener() {
       
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent event)  { 
         System.out.println("Attribute addded");
         System.out.println("ServletContext attribute added::{"+event.getName()+","+event.getValue()+"}");
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent event)  { 
    	 System.out.println("Attribute removed");
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent event)  { 
    	 System.out.println("Attribute replaced");
         System.out.println("ServletContext attribute added::{"+event.getName()+","+event.getValue()+"}");
    }
	
}
