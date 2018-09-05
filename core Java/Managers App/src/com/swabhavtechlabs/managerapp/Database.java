package com.swabhavtechlabs.managerapp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Database {
	
	String fileName = "serialized.ser";
	String csvFile = "student.csv";
	
	FileOutputStream fout = null;
	FileInputStream fin = null;
	PrintWriter pw = null;
	StringBuilder str = new StringBuilder();
	
	public boolean save(List<Manager> managers) {
		try {
			fout = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fout);
			
			out.writeObject(managers);
			
			out.close();
			fout.close();
			return true;
		} catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public List<Manager> retrieve() {
		List<Manager> managers = new ArrayList<>();
		try {
			fin = new FileInputStream(fileName);
			ObjectInputStream oin = new ObjectInputStream(fin);
			 managers = (ArrayList<Manager>)oin.readObject();
		}catch(IOException e) {
			System.out.println(e);
		} catch(ClassNotFoundException e) {
			System.out.println(e);
		}
		return managers;
	}
}
