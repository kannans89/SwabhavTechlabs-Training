package com.swabhavtechlabs.csvLoader;

import java.util.ArrayList;
import java.util.List;

public class Parser {
	ILoader iLoader;
	List<Employee> employees = null;
	
	Parser(ILoader loader) {
		this.iLoader = loader;
	}
	
	public List<Employee> getRecords() {
		List<String> records = iLoader.load();
		List<String[]> arrayOfRecords = createArrayOfrecords(records);
		arrayOfRecords = formatArrayOfRecords(arrayOfRecords);
		createEmployees(arrayOfRecords);
		return employees;
	}
	
	
	private void createEmployees(List<String[]> records) {
		for(String[] strArray: records) {
			employees.add(new Employee(Integer.parseInt(strArray[0]), strArray[2], strArray[1], strArray[3], strArray[4], Double.parseDouble(strArray[5]), Integer.parseInt(strArray[7])));
		}
	}
	
	private List<String[]> formatArrayOfRecords(List<String[]> arrayOfRecords){
		List<String[]> newArrayOfRecords = arrayOfRecords;
		int j =-1;
		for(String[] str: arrayOfRecords) {
			j++;
			//System.out.println(str[j]);
			for(int i=0; i<str.length; i++) {
				//System.out.println(newArrayOfRecords.get(j)[i].equals("NULL"));
				if(str[i].equals("NULL")) {
					//System.out.println(newArrayOfRecords.get(j)[i]);
					newArrayOfRecords.get(j)[i] = "0";
				}
			}
		}
		return newArrayOfRecords;
	}
	
	private List<String[]> createArrayOfrecords(List<String> records){
		List<String[]> recordArray = new ArrayList<>();
		for(String str: records) {
			recordArray.add(str.split(","));
		}
		return recordArray;
	}
	
	public void displayRecords(List<String> list) {
		for(String str: list) {
			System.out.println(str);
		}
	}
}
