package com.swabhavtechlabs.java;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CollegeTest {

	public static void printProffessorDetails(List<Proffessor> persons) {
		System.out.println("ID\tName\tAddress\t\tDate of birth\tSalary");
		System.out.println("---\t----\t-------\t\t-------------");
			for(Proffessor proffessor: persons) {
				System.out.print(proffessor.getId()+"\t");
				System.out.print(proffessor.getName()+"\t");
				System.out.print(proffessor.getAddress()+"\t\t");
				System.out.print(proffessor.getDateOfBirth()+"\t\t");
				System.out.println(proffessor.getSalary()+"\t");
			}
			System.out.println();
			System.out.println();
	}
	
	public static void printStudentsDetails(List<Student> students) {
		System.out.println("ID\tName\tAddress\t\tDate of birth");
		System.out.println("---\t----\t-------\t\t-------------");
			for(Student student: students) {
				System.out.print(student.getId()+"\t");
				System.out.print(student.getName()+"\t");
				System.out.print(student.getAddress()+"\t\t");
				System.out.println(student.getDateOfBirth()+"\t\t");
			}
	}

	public static void main(String args[]) {
		Branch branch = null;
		College college  = new College();
		
		String[] courses = {"Maths", "Science"};
		String date1 = "03/03/1997";
		Student student1 = new Student(111, "Manoj", "Virar", new SimpleDateFormat(date1), courses, branch.Computer);
		Student student2 = new Student(111, "Shubham", "Virar", new SimpleDateFormat(date1), courses, branch.Computer);

		Proffessor proffessor1 = new Proffessor(1001, "abc", "Mumbai", new SimpleDateFormat(date1), 10);
		Proffessor proffessor2 = new Proffessor(1002, "acd", "Mumbai", new SimpleDateFormat(date1), 15);

		college.addStudent(student1);
		college.addStudent(student2);
		college.addProffessor(proffessor1);
		college.addProffessor(proffessor2);
		college.caluclateSalary(college.getProffessors());
		
		printProffessorDetails(college.getProffessors());
		printStudentsDetails(college.getStudents());
	}
}
