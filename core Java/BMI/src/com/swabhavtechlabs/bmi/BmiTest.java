package com.swabhavtechlabs.bmi;

import java.util.Scanner;

public class BmiTest {

	public void printDetails(Bmi person) {
		if(person.getBMI() < 18) {
			System.out.println("Your BMI is "+person.getBMI()+" and it is considered as Underweight");
		} else if(person.getBMI() > 25){
			System.out.println("Your BMI is "+person.getBMI()+" and it is considered as Overweight");
		} else {
			System.out.println("Your BMI is "+person.getBMI()+" and it is considered as Normal");
		}
		System.out.println("<------------->");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BmiTest bmiTest = new BmiTest();
		double weight, height;
		
		System.out.print("Enter weight of a person in KG\t");
		System.out.println();
		weight = sc.nextDouble();
		System.out.print("Enter height of a person in meters");
		System.out.println();
		height = sc.nextDouble();
		
		Bmi person1 = new Bmi(weight, height);
		
		double bmi = person1.getBMI();
		person1.calculateBMI();
		bmiTest.printDetails(person1);
		
		person1.eat(6);
		bmiTest.printDetails(person1);
		
		person1.workout(1000);
		bmiTest.printDetails(person1);
	}

}
