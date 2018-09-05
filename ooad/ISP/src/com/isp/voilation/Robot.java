package com.isp.voilation;

import javax.management.RuntimeErrorException;

public class Robot implements IWorker{

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
	public void startEat() throws RuntimeErrorException{
		// TODO Auto-generated method stub
		throw new RuntimeErrorException(null, " robot cannot eat");
	}

	@Override
	public void stopEat() {
		// TODO Auto-generated method stub
		throw new RuntimeErrorException(null, "robot cannot eat");
	}

}
