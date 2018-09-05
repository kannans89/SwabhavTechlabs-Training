package com.swabhavtechlabs.rtoapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RTOTest {
	
	public static void main(String[] args) {
		String[] keys = {"MH", "KA", "MP", "K", "GJ", "AP", "TN", "PU", "RA", "UP"};
		String[] values = {"MAHARASTRA", "KARNATAKA", "MADHYAPRADESH", "KERALA", "GUJRAT", "ANDHRA PRADESH", "TAMILNADU", "PUNJAB", "RAJASTHAN", "UTTAR PRADESH"};
		
		final int DISPLAY = 1;
		final int SEARCH = 2;
		
		int again;
		
		DisplayAll display = new DisplayAll();
		Search search = new Search();
		Scanner sc = new Scanner(System.in);
		Database database= new Database();
		List<RTO> rtos = new ArrayList<RTO>();
		
		for(int i=0; i<keys.length; i++){
			rtos.add(new RTO(keys[i], values[i]));
		}
		
		database.writeToPropertyFile(rtos);
		rtos = database.readFromPropertiesFile();
		do {
			System.out.println("Menu ("+rtos.size()+")");
			System.out.print("Enter\n1. To display\n"
					+ "2. To Search\n");
			int choice = sc.nextInt();

			switch(choice) {
			case DISPLAY:
				display.displayAll(rtos);
				break;
			
			case SEARCH:
				for(RTO rto: rtos) {
					int result = search.search(rto, 'T');
					if(result == 1) {
						System.out.println(rto.getCode()+"\t"+rto.getState());
					}
				}
				break;
							
				default: System.out.println("Enter valid option...");
			}
			
			System.out.println("Want to continue?\t1/0");
			again = sc.nextInt();
		}while(again != 0);
	}

}
