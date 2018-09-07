package com.techlabs.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.model.Student;
import com.techlabs.service.StudentService;

public class GetStudentsByJSON extends ActionSupport{
	private String studentId;
	private String firstName;
	private String roll_no;
	private String gender;
	private double cgpi;
	private int id;
	private int col_id;
	Student student;
	StudentService studentService;
	
	public GetStudentsByJSON() {
		studentService = StudentService.getStudentService();
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String execute() {
		//studentId = ServletActionContext.getRequest().getParameter("student_id");
		student = studentService.getStudentById("101");
		System.out.println(student.getFirstName());
		firstName = student.getFirstName();
		roll_no = student.getRoll_no();
		gender = student.getGender();
		id = student.getId();
		cgpi = student.getCgpi();
		return "success";
	}
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getRoll_no() {
		return roll_no;
	}

	public void setRoll_no(String roll_no) {
		this.roll_no = roll_no;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getCgpi() {
		return cgpi;
	}

	public void setCgpi(double cgpi) {
		this.cgpi = cgpi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
