package com.swabhavtechlabs.studentexception;

import java.util.List;
import java.util.ArrayList;

public class StudentTest {
	public static void printDetails(List<Student> students, int id) throws StudentNotFoundException{
			for(Student student: students) {
				if(student.getId() == id) {
					return;
				}
			}

			throw new StudentNotFoundException("student not found");
	}
	public static void main(String argsp[]) {
		Student student1 = new Student(111, "Manoj");
		Student student2 = new Student(112, "Varshil");
		Student student3 = new Student(113, "abc");
		List<Student> students = new ArrayList<Student>();
		students.add(student1);
		students.add(student2);
		students.add(student3);
		
		try {
			printDetails(students, 111);
		}catch(StudentNotFoundException e) {
			System.out.println(e);
		}
	}
}
