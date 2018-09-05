package com.corejava.implement.runnable;

public class NewThread implements Runnable{
	Thread t;
	
	public NewThread() {
		t = new Thread(this, "Child Thread");
		System.out.println("Child: "+t);
		t.start();
	}
	
	@Override
	public void run() {
		try {
			for(int i=5; i>0; i--) {
				System.out.println(t+""+i);
				t.sleep(500);
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Exiting child thread");
	}
	
}
