package com.tech.appcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AppController
 */
@WebServlet("/appcontroller")
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = getServletConfig().getServletContext();
		String appcounter = new String("appcounter");
		Integer value = new Integer(0);
		PrintWriter out = response.getWriter();
			
		//application.getAttribute(appcounter);
		Integer counter = (Integer)application.getAttribute(appcounter);
		//out.println("Counter: "+counter);
		if(counter == null) {
			System.out.println("inside if");
			application.setAttribute(appcounter, 0);
		}
		
		application.setAttribute(appcounter, counter+1);
		out.println("Counter: "+counter);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
