package com.techlabs.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.model.Student;
import com.techlabs.service.CollegeService;
import com.techlabs.service.StudentService;

public class AddStudentAction extends ActionSupport implements Action {

	private static final String MALE = "male";
	private static final String FEMALE = "female";
	private static final String UNKNOWN = "unknown";
	private List<String> genders;
	private CollegeService collegeService;
	private StudentService studentService;
	private Student studentBean = new Student();
	private List<String> colleges;
	private String college_name;

	public String getCollege_name() {
		return college_name;
	}

	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}

	public List<String> getColleges() {
		return colleges;
	}

	public void setColleges(List<String> colleges) {
		this.colleges = colleges;
	}

	public Student getStudentBean() {
		return studentBean;
	}

	public void setStudentBean(Student studentBean) {
		this.studentBean = studentBean;
	}

//	public void validate() {
//		
//		HttpServletRequest req = ServletActionContext.getRequest();
//		String method = req.getMethod();
//		System.out.println("Student bean is "+studentBean);
//		if(method.equalsIgnoreCase("post")) {
//			System.out.println("Inside add stu reg validate post request "+studentBean.getName());
//			if(studentBean != null) {
//				if(studentBean.getRoll_no().equals("")) {
//					System.out.println("true roll_no");
//					addFieldError("studentBean.roll_no", "Roll number required");
//				}
//				if(studentBean.getCgpi()<0 && studentBean.getCgpi() >10) {
//					System.out.println("true cgpi "+studentBean.getCgpi());
//					addFieldError("studentBean.cgpi", "Cgpi required");
//				}
//			}
//		}		
//	}

	public AddStudentAction() {
		genders = new ArrayList<>();
		collegeService = CollegeService.getCollegeService();
		studentService = StudentService.getStudentService();
		colleges = new ArrayList<>();
		genders.add(MALE);
		genders.add(FEMALE);
		genders.add(UNKNOWN);
	}

	public List<String> getGenders() {
		return genders;
	}

	public void setGenders(List<String> genders) {
		this.genders = genders;
	}

	public String getDefaultGenderValue() {
		return UNKNOWN;
	}

	@Override
	public String execute() throws Exception {
//		String method = ServletActionContext.getRequest().getMethod();
		colleges = collegeService.getCollegesNames();
		System.out.println(colleges.get(0));
		return SUCCESS;
	}

	public String addTodb() {
		System.out.println("Inside addtodb");
		System.out.println(studentBean.getFirstName());
		System.out.println(college_name);
		int id = collegeService.getCollegeID(college_name);
		System.out.println(id);
		studentService.addStudent(new Student(studentBean.getFirstName(), studentBean.getRoll_no(), studentBean.getGender(),
				studentBean.getCgpi(), studentBean.getId(),id));
		return SUCCESS;
	}

}
