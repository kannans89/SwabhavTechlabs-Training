package com.isp.refactor;

public class Worker implements IWorkabelAndEatable{

	@Override
	public void startWork() {
		// TODO Auto-generated method stub
		System.out.println("Worker starts work");
	}

	@Override
	public void stopWork() {
		// TODO Auto-generated method stub
		System.out.println("Worker stops work");
	}

	@Override
	public void startEat() {
		// TODO Auto-generated method stub
		System.out.println("Worker starts eat");
	}

	@Override
	public void stopEat() {
		// TODO Auto-generated method stub
		System.out.println("Worker stops eat");
	}

}