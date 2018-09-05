package com.swabhavtechlabs.dougsDogDoor;

import java.util.Iterator;
import java.util.List;

public class BarkRecognizer {
	private DogDoor door;
	
	public BarkRecognizer(DogDoor door) {
		this.door = door;
	}
	
	public void recognizer(Bark bark) {
		System.out.println("  BarkRecognizer: Heard a ' "+bark.getSound()+" '");
		List<Bark> allowedBarks = door.getAllowedBarks();
		for(Bark newBark: allowedBarks) {
			if(newBark.equals(bark)) {
				door.open();
				return;
			}
		}
		if(door.getAllowedBark().equals(bark))
			door.open();
		System.out.println("This dog is not allowed");
	}
}
