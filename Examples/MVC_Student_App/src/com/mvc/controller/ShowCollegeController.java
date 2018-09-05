package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.model.College;
import com.mvc.service.CollegeService;

@WebServlet("/showcollege")
public class ShowCollegeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowCollegeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		CollegeService collegeService = CollegeService.getCollegeService();
		String id = (String)request.getParameter("cid");
		System.out.println("College id "+id);
		
		College college = collegeService.getCollegeById(id);
		System.out.println(college.getName());
		request.setAttribute("college", college);
		RequestDispatcher view = request.getRequestDispatcher("views/College.jsp");
		view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
