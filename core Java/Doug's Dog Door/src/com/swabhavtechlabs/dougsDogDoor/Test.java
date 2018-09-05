package com.swabhavtechlabs.dougsDogDoor;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		DogDoor dogDoor = new DogDoor();
		Remote remote = new Remote(dogDoor);
		BarkRecognizer recognizer = new BarkRecognizer(dogDoor);
		List<Bark> allowedBarks = new ArrayList<Bark>();
		allowedBarks.add(new Bark("woooof"));
		allowedBarks.add(new Bark("goooof"));
		allowedBarks.add(new Bark("boooof"));
		allowedBarks.add(new Bark("drooooof"));
		dogDoor.setAllowedBarks(allowedBarks);
		
		System.out.println("Barks to go outside");
		recognizer.recognizer(new Bark("Woof"));
		System.out.println("Has gone outside");
		System.out.println("All done...");
		
		try {
			Thread.currentThread().sleep(7000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("But dog is stuck outside");
		System.out.println("Starts to bark...");
		recognizer.recognizer(new Bark("Woof"));
		System.out.println("Back inside");
	}

}
