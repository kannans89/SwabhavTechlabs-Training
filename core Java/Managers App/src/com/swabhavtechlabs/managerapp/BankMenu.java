package com.swabhavtechlabs.managerapp;
import java.text.ParseException;
import java.util.Scanner;

public class BankMenu {
	
	public static void main(String[] args) throws JoindateBeforeBirthDate, ParseException, CodeIsNotUnique {
		Scanner sc = new Scanner(System.in);
		Administrator adminiStrator = new Administrator();	
		GetAndPrintDetails getAndPrint = new GetAndPrintDetails();	
		Bank bank = new Bank();
		int value;
		
		do {
			System.out.println("Total numbers of managers "+bank.getManagersList().size());
			System.out.println("Enter\n1.Add Manager\n2.Serialize\n3.Display");
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					adminiStrator.addManager(getAndPrint.getDetails());	
					break;
				
				case 2:
					adminiStrator.saveTodatabase();
					break;
					
				case 3:
					getAndPrint.printDetails(bank.getManagersList());
					break;
				default:
					System.out.println("Invalid choice");
			}
			System.out.println("Do you want to continue? 1/0");
			value = sc.nextInt();
		}while(value!=0);
		
		adminiStrator.saveTodatabase();
		System.out.println("Done!");
	}
}
