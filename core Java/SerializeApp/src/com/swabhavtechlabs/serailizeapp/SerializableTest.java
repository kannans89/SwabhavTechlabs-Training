package com.swabhavtechlabs.serailizeapp;

public class SerializableTest {
	
	public static void display(Student student, int count) {
		System.out.println("Student "+count);
		System.out.println("Name: "+student.getName());
		System.out.println("Roll number: "+student.getRollNumber());
		System.out.println("Email address: "+student.getEmail());
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		Student students[] = new Student[3];
		Database db1 = new Database();
		Student retrieveStudent = null;
		
		for(int i=0; i<students.length; i++) {
			students[i] = new Student("abc-"+(i+1)+"", 123+(i+1), "test"+(i+1)+"@test.gamil.com");
			db1.serialize(students[i]);
			retrieveStudent = db1.deSerialize();
			db1.export(retrieveStudent);
			display(retrieveStudent, i+1);
		}
	}
}
