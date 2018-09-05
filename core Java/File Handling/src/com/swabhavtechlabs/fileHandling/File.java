package com.swabhavtechlabs.fileHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class File {
	int i, j = 65;
	public void read(FileInputStream fin) {
		try {
			do {
				i = fin.read();
				if(i != 1)
					System.out.print((char) i);
			}while(i != -1);
		}catch(IOException e) {
			System.out.println("Error reading file");
		}
		
		finally{
			try {
				fin.close();
			}catch(IOException e) {
				System.out.println("Error closing file");
			}
		}
	}
	
	public void close(FileInputStream fin) {
		try {
			fin.close();
		} catch(IOException e) {
			System.out.println("Error closing file "+e);
		}
	}
	
	public void write(FileOutputStream fout) {
		try {
			do {
				fout.write(j++); 
				if(j==75)
					j=-1;
			} while(j != -1);
		}catch(IOException e) {
			System.out.println("error");
		}
		
		finally{
			try {
				fout.close();
			}catch(IOException e) {
				System.out.println("Error closing file");
			}
		}
	}
}
