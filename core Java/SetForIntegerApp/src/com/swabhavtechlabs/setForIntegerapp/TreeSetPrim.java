package com.swabhavtechlabs.setForIntegerapp;

import java.util.TreeSet;

public class TreeSetPrim {
	public void add(String str, TreeSet<String> hs) {
		hs.add(str);
	}

	public void delete(String str, TreeSet<String> hs) {
		hs.remove(str);
	}

	public boolean search(String str, TreeSet<String> hs) {
		return hs.contains(str);
	}

	public void update(String replaceStr, String replaceStrWith, TreeSet<String> hs) {
		for (Object str : hs) {
			if (str.equals(replaceStr)) {
				hs.remove(str);
				hs.add(replaceStrWith);
			}
		}
	}
}
