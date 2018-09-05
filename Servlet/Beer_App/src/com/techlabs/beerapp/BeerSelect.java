package com.techlabs.beerapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techlabs.beerapp.model.BeerExpert;

/**
 * Servlet implementation class BeerSelect
 */
@WebServlet("/BeerSelect.do")
public class BeerSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeerSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		BeerExpert be = new BeerExpert();
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		//pw.println("Beer selection advice<br/>");
		String color = request.getParameter("color");
		List<String> brands = be.getBrands(color);
		//pw.println("Got Beer color "+color);
		
//		for(String brand:brands) {
//			pw.println("<br>try: "+brand);
//		}
		
		request.setAttribute("brands", brands);
		RequestDispatcher view = request.getRequestDispatcher("views/result.jsp");
		view.forward(request, response);
	}

}
