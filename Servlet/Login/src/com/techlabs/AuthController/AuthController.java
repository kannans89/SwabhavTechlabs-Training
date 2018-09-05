package com.techlabs.AuthController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AuthController
 */
@WebServlet("/authcontroller")
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		System.out.println("Inside post");
		response.setContentType("text.html");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		PrintWriter pwriter = response.getWriter();
		System.out.println("Inside post "+name.equals("root"));
		if(!name.equals("root") && (!password.equals("root"))) {
			pwriter.println("<h1>Invalid user</h1>");
			System.out.println("Invlid user");
			response.sendRedirect("views/login.html");
		} else {
			pwriter.println("<h1>Valid user</h1>");
		}
	}

}
