package com.singleton.pattern;

public class Student {
	private static Student studentInstance;
	private int rollNo;
	private String name;
	
	private Student() {}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Student getInstance() { 
		if(studentInstance == null)
			studentInstance = new Student();
		return studentInstance;
	}
}
