package com.singleton.pattern;

public class Test {

	public static void main(String[] args) {
		Student student = Student.getInstance();
		Student student1 = Student.getInstance();

		if (student.hashCode() == student1.hashCode())
			System.out.println("Hash code: " + student.hashCode() + "\t" + student1.hashCode());
		else
			System.out.println("Objects are not equal");
	}
}
