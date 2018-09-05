package com.corejava.multiplethreads;

public class NewThread implements Runnable{
	Thread t;
	
	public NewThread(String name) {
		t = new Thread(this, name);
		System.out.println("Child Thread "+t.getName());
		t.start();
	}
	
	@Override
	public void run() {
		try {
			for(int i=0; i<5; i++) {
				System.out.println(t.getName()+" "+i);
				t.sleep(500);
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t.getName()+" exiting");
	}

}
