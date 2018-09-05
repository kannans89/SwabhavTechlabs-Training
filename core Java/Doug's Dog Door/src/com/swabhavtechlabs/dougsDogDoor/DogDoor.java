package com.swabhavtechlabs.dougsDogDoor;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {
	private boolean open;
	Bark allowedBark;
	List<Bark> allowedBarks;
	
	public Bark getAllowedBark() {
		return allowedBark;
	}

	public List<Bark> getAllowedBarks() {
		return allowedBarks;
	}

	public void setAllowedBark(Bark allowedBark) {
		this.allowedBark = allowedBark;
	}

	public void setAllowedBarks(List<Bark> allowedBarks) {
		this.allowedBarks = allowedBarks;
	}
	
	DogDoor(){
		this.open = false;
	}
	
	public void open() {
		System.out.println("Door is opened");
		this.open = true;
		
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				close();
				timer.cancel();
			}
		}, 5000);
	}
	
	public void close() {
		System.out.println("Door is closed");
		this.open = false;
	}
	
	public boolean isOpen() {
		return this.open;
	}
}
