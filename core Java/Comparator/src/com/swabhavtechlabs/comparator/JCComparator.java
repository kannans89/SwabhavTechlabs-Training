package com.swabhavtechlabs.comparator;

import java.util.Comparator;

public class JCComparator implements Comparator{

	public int compare(Object o1, Object o2) {
		Jobcandidate j1 = (Jobcandidate) o1;
		Jobcandidate j2 = (Jobcandidate) o2;
		return j1.getId() < j2.getId() ? -1 : j1.getId() > j2.getId() ? 1 : 0;
	}
}
