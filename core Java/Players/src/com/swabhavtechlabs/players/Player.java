package com.swabhavtechlabs.players;

public class Player {
	private String name;
	private int age;
	private String playerID = "player";

	static int count = 101;
	static {
	 count = 101;
	}
	
	Player(String name, int age) {
		this.name = name;
		this.age = age;
		this.playerID += count++;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getID() {
		return this.playerID;
	}
}
