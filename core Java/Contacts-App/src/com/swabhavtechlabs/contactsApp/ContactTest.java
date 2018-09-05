package com.swabhavtechlabs.contactsApp;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactTest {

	public static void display(ArrayList<Contact> contacts) {
		for(int i=0; i<contacts.size(); i++) {
			System.out.println("Contact "+(i+1));
			System.out.println("First name: "+contacts.get(i).getFirstName());
			System.out.println("First name: "+contacts.get(i).getLastName());
			System.out.println("First name: "+contacts.get(i).getEmail());
			System.out.println("");
		}
	}
		
	public static Contact getDetails(Scanner sc) {
		System.out.println("Enter first name\t");
		String firstName = sc.next();
		System.out.println("Enter last name\t");
		String lastName = sc.next();
		System.out.println("Enter email address");
		String email = sc.next();
		Contact contact = new Contact(firstName, lastName, email);
		return contact;
		
	}
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Contact> contacts= new ArrayList<Contact>();
		Scanner sc = new Scanner(System.in);
		ContactsShare share = new ContactsShare();
		ContactsShare share1 = new ContactsShare();
		System.out.println(share.hashCode());
		System.out.println(share1.hashCode());
		contacts = share.retrieve();
		int again;
		
		final int DISPLAY = 1;
		final int SAVE = 2;
		final int EXPORT = 3;
		
		do {
			System.out.println("Menu ("+contacts.size()+")");
			System.out.print("Enter\n1. To display contacts\n"
					+ "2. To add contacts\n"
					+ "3. To export contacts to csv file\n");
			int choice = sc.nextInt();

			switch(choice) {
			case DISPLAY: 
				display(share.retrieve());
				break;
			
			case SAVE:
				Contact contact = getDetails(sc);
				contacts.add(contact);
				share.save(contacts);
				break;
				
			case EXPORT:
				share.export(contacts);
				break;
							
				default: System.out.println("Enter valid option...");
			}
			
			System.out.println("Want to continue?\t1/0");
			again = sc.nextInt();
		}while(again != 0);
		
		share.save(contacts);
		share.export(contacts);
		System.out.print("Thank you for using our app");
	}

}
