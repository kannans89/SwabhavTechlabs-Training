package com.swabhavtechlabs.serailizeapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class Database {
	String fileName = "serialized.ser";
	String csvFile = "student.csv";
	
	FileOutputStream fout = null;
	FileInputStream fin = null;
	PrintWriter pw = null;
	StringBuilder str = new StringBuilder();
	
	public void serialize(Student student1) {
		try {
			fout = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fout);
			
			out.writeObject(student1);
			
			out.close();
			fout.close();
		} catch(IOException e) {
			System.out.println(e);
		}
	}
	
	public Student deSerialize() {
		Student student = null;
		try {
			fin = new FileInputStream(fileName);
			ObjectInputStream oin = new ObjectInputStream(fin);
			
			 student = (Student)oin.readObject();
		}catch(IOException e) {
			System.out.println(e);
		} catch(ClassNotFoundException e) {
			System.out.println(e);
		}
		return student;
	}
	
	public void export(Student student) throws FileNotFoundException{
		pw = new PrintWriter(new File(csvFile));
		str.append(student.getName());
		str.append(",");
		str.append(student.getRollNumber());
		str.append(",");
		str.append(student.getEmail());
		str.append('\n');
		pw.write(str.toString());
		pw.close();
		System.out.println("Done!");
	}
}
