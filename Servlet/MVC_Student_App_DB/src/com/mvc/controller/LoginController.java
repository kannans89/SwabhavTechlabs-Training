package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.model.User;
import com.mvc.service.AuthenticationService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+" "+password);
		HttpSession session = request.getSession();
		AuthenticationService authService = AuthenticationService.getAuthService();
		boolean authState = authService.checkUser(new User(username, password));
		if(authState) {
			System.out.println("Login successfull");
			
			session.setAttribute("username", username);
			System.out.println("User name from login controller "+username);
			
			response.sendRedirect("/MVC_Student_App_DB/showstudent");
		} else {
			System.out.println("Invalid credentials");
			RequestDispatcher view = request.getRequestDispatcher("views/login.html");
			session.setAttribute("username", null);
			view.forward(request, response);
		}
	}

}
