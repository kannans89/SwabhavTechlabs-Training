package com.techlabs.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.model.Student;
import com.techlabs.service.StudentService;

public class EditStudentAction extends ActionSupport {
	private static final String MALE = "male";
	private static final String FEMALE = "female";
	private static final String UNKNOWN = "unknown";
	StudentService service;
	private List<String> genders;
	public List<String> getGenders() {
		return genders;
	}

	public void setGenders(List<String> genders) {
		this.genders = genders;
	}

	public String getFirstName() {
		System.out.println("Inside getfirstname "+firstName);
		return firstName;
	}

	public void setFirstName(String firstName) {
		System.out.println("Inside setfirstname "+firstName);
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

	private String firstName;
	private String roll_no;
	private String gender;
	private double cgpi;
	private int id;
	private int col_id;
	
	public int getCol_id() {
		return col_id;
	}

	public void setCol_id(int col_id) {
		this.col_id = col_id;
	}

	String studentId;
	public EditStudentAction() {
		studentId = ServletActionContext.getRequest().getParameter("id");
		System.out.println("from edit student action"+studentId);
		service = StudentService.getStudentService();
		Student studentBean = service.getStudentById(studentId);
		System.out.println(studentBean.getFirstName());
		setFields(studentBean);
		System.out.println(studentBean);
		
		genders = new ArrayList<>();
		service = StudentService.getStudentService();
		genders.add(MALE);
		genders.add(FEMALE);
		genders.add(UNKNOWN);
	}

	@Override
	public String execute() throws Exception{
//		String id = ServletActionContext.getRequest().getParameter("id");
//		service = StudentService.getStudentService();
//		Student studentBean = service.getStudentById(id);
//		setFields(studentBean);
//		System.out.println(studentBean);
		System.out.println("Inside edit student");
		return SUCCESS;
	}

	public void setFields(Student student) {
		firstName = student.getFirstName();
		roll_no = student.getRoll_no();
		gender = student.getGender();
		cgpi = student.getCgpi();
		id = student.getId();
		col_id = student.getCol_id();
	}
	
	private String firstName1;
	
	public String getFirstName1() {
		System.out.println("Inside getfirstname1 "+firstName1);

		return firstName1;
	}

	public void setFirstName1(String firstName1) {
		this.firstName1 = firstName1;
		System.out.println("Inside setfirstname1 "+firstName1);
	}

	public String updateStudent() {
		System.out.println(firstName);
		System.out.println(firstName1);
		System.out.println(id);
		System.out.println(roll_no);
		System.out.println(gender);
		System.out.println(col_id);
		service.updateStudent(id+"",new Student(firstName, roll_no, gender, cgpi, id, col_id));
		return SUCCESS;
	}
}
