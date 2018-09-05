package com.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.model.College;
import com.mvc.model.Student;
import com.mvc.service.CollegeService;
import com.mvc.service.StudentService;

@WebServlet("/addstudent")
public class AddStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddStudentController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("views/AddStudent.jsp");
		CollegeService collegeService = CollegeService.getCollegeService();

		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");

		if (username == null) {
			response.sendRedirect("views/login.html");
		} else {
			Map<String, String> colleges = new HashMap<>();
			try {
				colleges = collegeService.getCollegeIdNames();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			request.setAttribute("collegeNameIdMap", colleges);

			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		StudentService studentService = StudentService.getStudentService();
		CollegeService collegeService = CollegeService.getCollegeService();

		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			response.sendRedirect("views/login.html");
		} else {
			Map<String, String> colleges = new HashMap<>();
			try {
				colleges = collegeService.getCollegeIdNames();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("username is " + username);
			String firstName = request.getParameter("first_name");
			String lastName = request.getParameter("last_name");
			String cgpa = request.getParameter("cgpa");
			String college_id = request.getParameter("college_name");
			String roll_no = request.getParameter("roll_no");
			
			System.out.println(firstName);
			System.out.println(lastName);
			System.out.println(cgpa);
			System.out.println(college_id);
			String parsedfirstName = "";
			String parsedlastName = "";
			double parsedcgpa = 0;
			String parsedCollege_id = "";
			String parsedRoll_no = "";

			request.setAttribute("firstName", firstName);
			request.setAttribute("lastName", lastName);
			request.setAttribute("cgpa", cgpa);
			request.setAttribute("college_id", college_id);
			request.setAttribute("roll_no", parsedRoll_no);
			request.setAttribute("collegeNameIdMap", colleges);

			if (firstName.equals("") || lastName.equals("") || cgpa.equals("") || college_id.equals("")) {
				RequestDispatcher view = request.getRequestDispatcher("views/AddStudent.jsp");
				request.setAttribute("error", new String("Please enter all the values"));

				view.forward(request, response);
			} else {
				parsedRoll_no = (String) roll_no;
				parsedfirstName = (String) firstName;
				parsedlastName = (String) lastName;
				parsedcgpa = Double.parseDouble(cgpa);
				parsedCollege_id = (String) college_id;
				try {
					studentService.addStudent(new Student(Integer.parseInt(parsedRoll_no), parsedfirstName,
							parsedlastName, parsedcgpa, parsedCollege_id));
				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				response.sendRedirect("/MVC_Student_App_DB/showstudent");
			}
		}

	}

}
