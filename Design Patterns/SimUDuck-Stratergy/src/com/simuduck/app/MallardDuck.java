package com.simuduck.app;

public class MallardDuck extends Duck{

	public MallardDuck() {
		quackBehaviour = new Quack();
		flyBehaviour = new flyWithWings();
	}
	@Override
	public void display() {
		System.out.println("Mallard Duck");
		
	}

}
