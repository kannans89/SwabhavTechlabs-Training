package com.swabhavtechlabs.bmi;

public class Bmi {
	private double weight, height, bmi;
	
	Bmi(double weight, double height) {
		this.weight = weight;
		this.height = height;
	}
	
	public void calculateBMI() {
		bmi = weight/(height*height);
	}
	
	public double getBMI() {
		return this.bmi;
	}
	
	public void eat(int meal) {
		this.weight += meal/2;
		calculateBMI();
	}
	
	public void workout(int minutes) {
		if(minutes > 45) 
			this.weight -= minutes*0.01;
		 else if(minutes > 15 && minutes < 45)
			this.weight -= 0.5;
		
		calculateBMI();
	}
}
