package com.swabhavtechlabs.fileHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileTest {

	public static void main(String[] args) {
		File file = new File();
		FileInputStream fin = null;
		FileOutputStream fout = null;
		try {
			 fin = new FileInputStream("temp5.txt");
			 fout = new FileOutputStream("temp1.txt");
		} catch(FileNotFoundException e) {
			System.out.println("Cannot open file "+e);
		}

		file.read(fin);
		file.close(fin);
		
		file.write(fout);
	}

}
