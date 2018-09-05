package com.threadsafesingleton.app;

public class ThreadSafeSingleTon {
	private int value;
	private static ThreadSafeSingleTon instance;
	
	private ThreadSafeSingleTon() {}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	public static ThreadSafeSingleTon getInstance() {
		if(instance == null) {
			synchronized (ThreadSafeSingleTon.class) {
				instance = new ThreadSafeSingleTon();
			}
		}
		return instance;
	}
}
