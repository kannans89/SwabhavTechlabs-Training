package com.isp.refactor;

import com.isp.voilation.IWorker;

public class Test {

	public static void atCafe(IEatable worker) {
		worker.startEat();
		worker.stopEat();
		
	}
	public static void atWork(IWorkable worker) {
		worker.startWork();
		worker.stopWork();
	}
	public static void main(String[] args) {
		IWorkabelAndEatable workableAndEatble;
		workableAndEatble = new Worker();
		atCafe(workableAndEatble);
		atWork(workableAndEatble);
		
		IWorkable workable;
		workable = new Robot();
		atWork(workable);
		//atCafe(workable);
	}

}
