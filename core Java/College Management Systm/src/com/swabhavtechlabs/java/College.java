package com.swabhavtechlabs.java;

import java.util.ArrayList;
import java.util.List;

public class College implements Salary{
	List<Student> students = new ArrayList<>();
	List<Proffessor> proffessors = new ArrayList<>();


	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public List<Proffessor> getProffessors() {
		return proffessors;
	}

	public void addProffessor(Proffessor proffessor) {
		proffessors.add(proffessor);
	}

	@Override
	public void caluclateSalary(List<Proffessor> professors) {
		for(Proffessor proffessor: professors) {
			proffessor.setSalary(proffessor.getNoOfHours()*500);
		}	
	}
}
