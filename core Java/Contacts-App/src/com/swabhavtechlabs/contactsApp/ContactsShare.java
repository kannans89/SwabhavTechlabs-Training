package com.swabhavtechlabs.contactsApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ContactsShare {
	
	String fileName = "serialized.ser";
	String csvFile = "student.csv";
	
	FileOutputStream fout = null;
	FileInputStream fin = null;
	PrintWriter pw = null;
	StringBuilder str = new StringBuilder();
	
	public void save(ArrayList<Contact> contacts) {
		try {
			fout = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fout);
			
			out.writeObject(contacts);
			
			out.close();
			fout.close();
		} catch(IOException e) {
			System.out.println(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Contact> retrieve() {
		ArrayList<Contact> contacts = null;
		try {
			fin = new FileInputStream(fileName);
			ObjectInputStream oin = new ObjectInputStream(fin);
			 contacts = (ArrayList<Contact>)oin.readObject();
		}catch(IOException e) {
			System.out.println(e);
		} catch(ClassNotFoundException e) {
			System.out.println(e);
		}
		return contacts;
	}
	
	public void export(ArrayList<Contact> contacts) throws FileNotFoundException{
		pw = new PrintWriter(new File(csvFile));
		
		for(int i=0; i<contacts.size(); i++) {
			str.append(contacts.get(i).getFirstName());
			str.append(",");
			str.append(contacts.get(i).getLastName());
			str.append(",");
			str.append(contacts.get(i).getEmail());
			str.append('\n');
		}
		pw.write(str.toString());
		pw.close();
		System.out.println("Done!");
	}
}
