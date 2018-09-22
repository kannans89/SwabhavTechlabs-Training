package com.techlabs.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.entity.User;
import com.techlabs.repository.UserRepository;

public class RegisterUserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private List<String> genderList = null;
	private User userBean = null;
	private UserRepository userRepo = null;

	@Autowired
	public void setUserRepo(UserRepository repo) {
		this.userRepo = repo;
	}

	public RegisterUserAction() {
		genderList = new ArrayList<String>();
		initializeGender();
		userBean = new User();
	}

	public String execute() {
		return SUCCESS;
	}

	public String registerUser() {
		System.out.println("inisde register user");
		User user = new User(Math.abs(UUID.randomUUID().getMostSignificantBits()), userBean.getFirst_name(),
				userBean.getLast_name(), userBean.getEmail(), userBean.getPassword(), userBean.getGender(),
				userBean.getDob());
		this.userRepo.addUser(user);
		return SUCCESS;
	}

	private void initializeGender() {
		this.genderList.add("Male");
		this.genderList.add("Female");
	}

	public List<String> getGenderList() {
		return genderList;
	}

	public void setGenderList(List<String> genderList) {
		this.genderList = genderList;
	}

	public User getUserBean() {
		return userBean;
	}

	public void setUserBean(User userBean) {
		this.userBean = userBean;
	}
}
