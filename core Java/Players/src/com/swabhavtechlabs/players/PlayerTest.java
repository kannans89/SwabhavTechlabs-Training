package com.swabhavtechlabs.players;

public class PlayerTest {
	static int count = 1;
	public static void printDetails(Player player) {
		System.out.println("Player "+count++);
		System.out.println();
		System.out.println("ID: "+player.getID());
		System.out.println("Name: "+player.getName());
		System.out.println("Age: "+player.getAge());
		System.out.println();
		System.out.println("<------------->");
		System.out.println();
	}
	
	public static void main(String args[]) {
		Player player1 = new Player("Manoj", 21);
		printDetails(player1);
		
		Player player2 = new Player("Anil", 20);
		printDetails(player2);
		
		Player player3 = new Player("Kiran", 19);
		printDetails(player3);
	}
}
