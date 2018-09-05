package com.swabhavtechlabs.firstsecondlargest;

import java.util.Scanner;

public class First_Second_largest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size, first, second = -1;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter how many elements in an array?\t");
		size = sc.nextInt();
		System.out.println();
		int inputArray[] = new int[size];
		
		System.out.println("Enter "+ size + " elements");
		for(int i=0; i<size; i++) {
			inputArray[i] = sc.nextInt();
		}
		
		first = inputArray[0];
		
		for(int i=0; i<size; i++) {
			if(first < inputArray[i]) {
				second = first;
				first = inputArray[i];
			}
			
			if(inputArray[i] != first && inputArray[i] > second) {
				second = inputArray[i];
			}
		}
		
		System.out.println("First largest is "+ first + " and the second largest is "+ second + " ");
	}

}
