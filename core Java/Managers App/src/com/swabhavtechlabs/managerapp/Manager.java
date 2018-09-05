package com.swabhavtechlabs.managerapp;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Manager implements Serializable{

	private static final long serialVersionUID = 1L;
	transient CheckParameters checkParameter = new CheckParameters();
	private String name;
	private String code;
	private Specilization specilization;
	private Date birthDate, joiningDate;
	private boolean workingCurrently;
	private double ctc;
	
	public Manager(String name, String code, Specilization specilization, Date birthDate, Date joiningDate, boolean working, double ctc) throws CodeIsNotUnique, JoindateBeforeBirthDate, CTCNegetiveException {
		this.name = name;
		this.specilization = specilization;
		this.birthDate = birthDate;
		this.workingCurrently = working;
		this.ctc = ctc;
		this.code = generateCode();
		this.joiningDate = checkdate(joiningDate);
	}

	private String generateCode() {
		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		Date date = new Date();
		String formattedDate = formatter.format(date);
		formattedDate = modifyString(formattedDate);
		return formattedDate;
	}
	
	public Manager() {}
	
	public String modifyString(String date) {
		String[] dateArray = date.split(" ");
		String[] newDate = dateArray[0].split("-");
		String[] newTime = dateArray[1].split(":");
		String updatedDateAndTime = newDate[0]+newDate[1]+newDate[2];
		updatedDateAndTime += newTime[0]+newTime[1]+newTime[2];
		return updatedDateAndTime;
	}
	
	private String checkCode(String code) {
		if(!checkParameter.codeIsUnique(code))
			throw new CodeIsNotUnique("Code is not unique");
		else
			return code;
	}

	private Date checkdate(Date joiningDate) {
		if(!checkParameter.joiningGreaterThanBirthDate(birthDate, joiningDate))
			throw new JoindateBeforeBirthDate("Join date is before birthdate");
		else
			return joiningDate;
	}
	
	private double checkCTC(double ctc) {
		if(checkParameter.isCTCPositive(ctc))
			throw new CTCNegetiveException("CTC should not be negetive");
		else
			return ctc;
	}
	
	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public Specilization getSpecilization() {
		return specilization;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public boolean isWorkingCurrently() {
		return workingCurrently;
	}

	public double getCtc() {
		return ctc;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setSpecilization(Specilization specilization) {
		this.specilization = specilization;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public void setWorkingCurrently(boolean workingCurrently) {
		this.workingCurrently = workingCurrently;
	}

	public void setCtc(double ctc) {
		this.ctc = ctc;
	}
}
