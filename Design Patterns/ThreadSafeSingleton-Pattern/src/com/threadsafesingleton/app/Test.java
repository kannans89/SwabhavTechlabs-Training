package com.threadsafesingleton.app;

public class Test {
	public static void main(String[] args) {
		ThreadSafeSingleTon singleton = ThreadSafeSingleTon.getInstance();
		singleton.setValue(50);
		ThreadSafeSingleTon singleTon2 = ThreadSafeSingleTon.getInstance();
		singleTon2.setValue(45);
		
		System.out.println(singleton.getValue());
		System.out.println(singleTon2.getValue());
	}
}
