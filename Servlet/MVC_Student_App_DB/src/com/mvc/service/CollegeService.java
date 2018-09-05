package com.mvc.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mvc.model.College;
import com.mvc.repo.CollegeRepository;
import com.mvc.repo.StudentRepository;

public class CollegeService {
	private List<College> colleges = null;
	private static CollegeService collegeService = null;
	CollegeRepository collegeRepo = null;
	
	private CollegeService() {
		colleges = new ArrayList<College>();
		collegeRepo = new CollegeRepository();
		//createColleges();
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
	
	public List<College> getColleges() throws SQLException {
		colleges = this.collegeRepo.getColleges();
		return colleges;
	}
	
	public void createColleges() {
		colleges.add(new College("c101", "St. John", "Palghar"));
		colleges.add(new College("c102", "St. Joseph", "Mangalore"));
		colleges.add(new College("c103", "VJTI", "Matunga"));
	}
	
	public College getCollegeById(String id) throws SQLException {
		List<College> colleges = this.collegeRepo.getColleges();
		for(College college:colleges) {
			if(college.getCollege_id().equals(id)) {
				return college;
			}
		}
		return null;
	}
	
	public Map<String, String> getCollegeIdNames() throws SQLException{
		return this.collegeRepo.getCollegeIdNames();
	}
}
