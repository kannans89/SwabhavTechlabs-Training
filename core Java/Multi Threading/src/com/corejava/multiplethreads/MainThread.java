package com.corejava.multiplethreads;

public class MainThread {
	public static void main(String[] args) {
		NewThread thread1 = new NewThread("one");
		NewThread thread2 = new NewThread("two");
		NewThread thread3 = new NewThread("Three");
		
		System.out.println("Thread 1 is alive "+thread1.t.isAlive());
		System.out.println("Thread 2 is alive "+thread2.t.isAlive());
		System.out.println("Thread 3 is alive "+thread3.t.isAlive());
		
		try {
			thread1.t.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Thread 1 is alive "+thread1.t.isAlive());
		System.out.println("Thread 2 is alive "+thread2.t.isAlive());
		System.out.println("Thread 3 is alive "+thread3.t.isAlive());
		
		System.out.println(Thread.currentThread().getName()+" exiting");
	}
}
