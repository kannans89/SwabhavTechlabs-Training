package com.mvc.service;

import java.util.ArrayList;
import java.util.List;

import com.mvc.model.College;

public class CollegeService {
	private List<College> colleges = null;
	private static CollegeService collegeService = null;
	
	private CollegeService() {
		colleges = new ArrayList<College>();
		createColleges();
	}
	
	public static CollegeService getCollegeService() {
		System.out.println("inside  collegeService");
		if(collegeService == null) {
			System.out.println("Inside object creation of collegeService");
			collegeService = new CollegeService();
			
			return collegeService;
		}
		System.out.println("Inside collegeService outside if");
		return collegeService;
	}
	
	public List<College> getColleges() {
		return this.colleges;
	}
	
	public void createColleges() {
		colleges.add(new College("c101", "St. John", "Palghar"));
		colleges.add(new College("c102", "St. Joseph", "Mangalore"));
		colleges.add(new College("c103", "VJTI", "Matunga"));
	}
	
	public College getCollegeById(String id) {
		for(College college:colleges) {
			if(college.getCollege_id().equals(id)) {
				return college;
			}
		}
		return null;
	}
}
