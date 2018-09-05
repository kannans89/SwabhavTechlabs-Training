package com.techlabs.listeners;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Application Lifecycle Listener implementation class AppRequestListener
 *
 */
public class AppRequestListener implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public AppRequestListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
    	ServletRequest servletRequest = sre.getServletRequest();
    	System.out.println("ServletRequest destroyed. Remote IP="+servletRequest.getRemoteAddr());
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
    	ServletRequest servletRequest = sre.getServletRequest();
    	System.out.println("ServletRequest initialized. Remote IP="+servletRequest.getRemoteAddr());
    }
	
}
