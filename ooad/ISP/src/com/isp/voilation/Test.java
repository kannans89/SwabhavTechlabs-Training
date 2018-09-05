package com.isp.voilation;

public class Test {

	public static void atCafe(IWorker worker) {
		worker.startEat();
		worker.stopEat();
		
	}
	public static void atWork(IWorker worker) {
		worker.startWork();
		worker.stopWork();
	}
	public static void main(String[] args) {
		IWorker worker;
		worker = new Worker();
		atCafe(worker);
		atWork(worker);
		worker = new Robot();
		atWork(worker);
		atCafe(worker);
		
	}

}
