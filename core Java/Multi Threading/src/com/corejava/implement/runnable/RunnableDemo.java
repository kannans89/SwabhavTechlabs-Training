package com.corejava.implement.runnable;

public class RunnableDemo {

	public static void main(String[] args) {
		new NewThread();
		
		try {
			for(int i=5; i>0; i--) {
				System.out.println(Thread.currentThread()+""+i);
				Thread.sleep(1000);
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Exiting Main thread");
	}

}
