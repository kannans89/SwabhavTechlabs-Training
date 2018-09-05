package com.tech.sessioncontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class SessionController
 */
@WebServlet("/sessioncontroller")
public class SessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String counter = new String("counter");
		Integer value = new Integer(0);
		PrintWriter pwriter = response.getWriter();
		
		HttpSession session = request.getSession();
		
		if(session.isNew()) {
			session.setAttribute(counter, value);
			pwriter.println("Counter: "+0);
		}
		
		value = (Integer)session.getAttribute(counter);
		pwriter.println("Counter: "+value);
		value += 1;
		session.setAttribute(counter, value);
		pwriter.println("Counter: "+value);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
