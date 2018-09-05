package com.swabhavtechlabs.setForIntegerapp;

import java.util.LinkedHashSet;

public class LinkedHashSetPrim {
	public void add(String str, LinkedHashSet<String> hs) {
		hs.add(str);
	}

	public void delete(String str, LinkedHashSet<String> hs) {
		hs.remove(str);
	}

	public boolean search(String str, LinkedHashSet<String> hs) {
		return hs.contains(str);
	}

	public void update(String replaceStr, String replaceStrWith, LinkedHashSet<String> hs) {
		for (Object str : hs) {
			if (str.equals(replaceStr)) {
				hs.remove(str);
				hs.add(replaceStrWith);
			}
		}
		
		for(int i=0; i<hs.size(); i++) {
			if(hs.contains(replaceStr)) {
				hs.remove(replaceStr);
				hs.add(replaceStrWith);
			}
		}
	}
}
