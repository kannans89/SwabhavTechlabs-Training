package com.swabhavtechlabs.setForIntegerapp;

import java.util.HashSet;

public class HashSetPrim {
	public void add(String str, HashSet<String> hs) {
			hs.add(str);
		}
	
	public void delete(String str, HashSet<String> hs) {
		hs.remove(str);
	}
	
	public boolean search(String str, HashSet<String> hs) {
		return hs.contains(str);
	}
	
	public void update(String replaceStr,String replaceStrWith, HashSet<String> hs) {
		for(Object str: hs) {
			if(str.equals(replaceStr)) {
				hs.remove(str);
				hs.add(replaceStrWith);
			}
		}
	}
}
