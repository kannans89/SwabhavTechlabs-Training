package com.swabhavtechlabs.setForIntegerapp;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetTest {

	public static void displayHashSet(HashSet<String> hs) {
		System.out.println("hash set");
		for(Object str: hs) {
			System.out.println(str+"\t");
		}
		System.out.println();
		System.out.println("---------------");
	}
	
	public static void displayLinkedHashSet(LinkedHashSet<String> ls) {
		System.out.println("LSH set");
		for(Object str: ls) {
			System.out.println(str+"\t");
		}
		System.out.println();
	}
	
	public static void displayTreeSet(TreeSet<String> ts) {
		treeSet1(ts);
	}

	private static void treeSet1(TreeSet<String> ts) {
		System.out.println("Tree set");
		for(Object str: ts) {
			System.out.println(str+"\t");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		HashSetPrim hsp = new HashSetPrim();
		HashSet<String> hs = new HashSet<String>();
		hsp.add("Manoj", hs);
		hsp.add("abc", hs);
		displayHashSet(hs);
		hsp.delete("abc", hs);
		displayHashSet(hs);
		hsp.add("cbc", hs);
		boolean result = hsp.search("Manoj", hs);
		hsp.update("Manoj", "fbuidsbcvudn", hs);
		displayHashSet(hs);
		
		//testLinkedHashSet();
		
		TreeSetPrim tsp = new TreeSetPrim();
		TreeSet<String> ts = new TreeSet<String>();
		tsp.add("Manoj", ts);
		tsp.add("abc", ts);
		displayTreeSet(ts);
		tsp.delete("abc", ts);
		displayTreeSet(ts);
		tsp.add("cbc", ts);
		boolean result2 = tsp.search("Manoj", ts);
		//tsp.update("Manoj", "fbuidsbcvudn", ts);
		displayTreeSet(ts);
	}

	private static void testLinkedHashSet() {
		LinkedHashSetPrim lsp = new LinkedHashSetPrim();
		LinkedHashSet<String> ls = new LinkedHashSet<>();
		lsp.add("Manoj", ls);
		lsp.add("abc", ls);
		displayLinkedHashSet(ls);
		lsp.delete("abc", ls);
		displayLinkedHashSet(ls);
		lsp.add("cbc", ls);
		boolean result1 = lsp.search("Manoj", ls);
		//lsp.update("Manoj", "fbuidsbcvudn", ls);
		displayLinkedHashSet(ls);
	}

}
