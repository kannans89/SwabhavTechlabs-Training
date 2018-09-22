package com.techlabs.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.techlabs.entity.Customer;
import com.techlabs.repository.CustomerRepository;

public class RegisterUserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private List<String> genderList = null;
	private Customer customerBean = null;
	private CustomerRepository customerRepo = null;

	@Autowired
	public void setUserRepo(CustomerRepository repo) {
		this.customerRepo = repo;
	}

	public RegisterUserAction() {
		genderList = new ArrayList<String>();
		initializeGender();
		customerBean = new Customer();
	}

	public String execute() {
		return SUCCESS;
	}

	public String registerUser() {
		System.out.println("inisde register user");
		Customer user = new Customer(Math.abs(UUID.randomUUID().getMostSignificantBits()), customerBean.getFirst_name(),
				customerBean.getLast_name(), customerBean.getEmail(), customerBean.getPassword());
		this.customerRepo.addUser(user);
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

	public Customer getUserBean() {
		return customerBean;
	}

	public void setUserBean(Customer userBean) {
		this.customerBean = userBean;
	}
}
