package com.swabhavtechlabs.csvLoader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DiskLoader implements ILoader{
	List<String> records = new ArrayList<>();
	public List<String> load(){
		try(BufferedReader br= new BufferedReader(new FileReader(new File("dataFile.txt")))) {
			String line;
			while((line = br.readLine()) != null) {
				records.add(line);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return records;
	}
}
