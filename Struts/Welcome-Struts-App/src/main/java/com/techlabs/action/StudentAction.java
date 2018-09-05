package com.techlabs.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.techlabs.model.Student;
import com.techlabs.service.StudentService;

public class StudentAction implements Action{

	private List<Student> students = new ArrayList<>();
	
	public List<Student> getStudents() {
		System.out.println("inside get students");
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}


	@Override
	public String execute() throws Exception {
		StudentService service = StudentService.getStudentService();
		this.students = service.getStudents();
		return "success";
	}

}
