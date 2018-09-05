package com.swabhavtechlabs.comparable;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CandidateTest {
	public static void main(String[] args) {
		Jobcandidate candidate1 = new Jobcandidate(101, 1000, "xbc", 20);
		Jobcandidate candidate2 = new Jobcandidate(105, 1000, "kbc", 25);
		Jobcandidate candidate3 = new Jobcandidate(102, 1000, "abc", 15);
		Jobcandidate candidate4 = new Jobcandidate(103, 1000, "ebc", 35);
		
		List<Jobcandidate> listOfJobCandidates = new ArrayList<Jobcandidate>();
		listOfJobCandidates.add(candidate1);
		listOfJobCandidates.add(candidate2);
		listOfJobCandidates.add(candidate3);
		listOfJobCandidates.add(candidate4);
		
		System.out.println("Before Sorting");
		for(int i=0; i<listOfJobCandidates.size(); i++) {
			Jobcandidate candidate = (Jobcandidate) listOfJobCandidates.get(i);
			System.out.println("Candidate "+(i+1));
			System.out.println("Name: "+candidate.getName());
			System.out.println("ID: "+candidate.getId());
			System.out.println("Salary: "+candidate.getSalary());
			System.out.println("Age: "+candidate.getAge());
			System.out.println();
		}
		
		new CandidateSort().getSortedListOfCondidate(listOfJobCandidates);
		
		System.out.println("After Sorting");
		for(int i=0; i<listOfJobCandidates.size(); i++) {
			Jobcandidate candidate = (Jobcandidate) listOfJobCandidates.get(i);
			System.out.println("Candidate "+(i+1));
			System.out.println("Name: "+candidate.getName());
			System.out.println("ID: "+candidate.getId());
			System.out.println("Salary: "+candidate.getSalary());
			System.out.println("Age: "+candidate.getAge());
			System.out.println();
		}
	}
}
