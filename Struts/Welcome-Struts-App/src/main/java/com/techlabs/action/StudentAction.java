package com.techlabs.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.techlabs.interceptors.UserAware;
import com.techlabs.model.Student;
import com.techlabs.service.StudentService;

public class StudentAction implements Action, UserAware{

	private List<Student> students = new ArrayList<>();
	private HttpServletRequest req = ServletActionContext.getRequest();
	private HttpSession session = req.getSession();
	private String username; 
	public List<Student> getStudents() {
		System.out.println("inside get students");
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}


	@Override
	public String execute() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		httpResponse.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); 
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		httpResponse.setHeader("Pragma","no-cache"); 
		httpResponse.setDateHeader ("Expires", 0); 
		System.out.println("from student action User name "+session.getAttribute("username"));
		StudentService service = StudentService.getStudentService();
		this.students = service.getStudents();
		return "success";
		
		
//		if(session.getAttribute("username") != null) {
//			System.out.println("from student action User name "+session.getAttribute("username"));
//			StudentService service = StudentService.getStudentService();
//			this.students = service.getStudents();
//			return "success";
//		} else {
//			System.out.println("from student action User name "+session.getAttribute("username"));
//			return "error";
//		}
	}

	@Override
	public void setUser(String user) {
		this.username = user;
		
	}

}
