package com.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.model.Student;
import com.mvc.service.StudentService;

/**
 * Servlet implementation class ShowStudentsInCollegeController
 */
@WebServlet("/showstudents")
public class ShowStudentsInCollegeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowStudentsInCollegeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside show students");
		StudentService service = StudentService.getStudentService();
		String collegeId = request.getParameter("cid");
		System.out.println("College id: "+collegeId);
		
		List<Student> studentsList = null;
		try {
			System.out.println("Inside show student controller");
			studentsList = service.getStudentsByCollegeId(collegeId);
			RequestDispatcher view = request.getRequestDispatcher("views/ShowStudents.jsp");
			request.setAttribute("studentsList", studentsList);
			view.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletReqmuest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
