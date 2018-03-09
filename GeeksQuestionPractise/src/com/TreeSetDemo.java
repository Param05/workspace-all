package com;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo {
	public static void main(String[] args) {
		TreeSet<Object> t = new TreeSet<>();
		t.add(new StringBuffer("c"));
		t.add(new StringBuffer("B"));
		System.out.println(t); // by default sorting order

	}
}

class MyComparator implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		String s1 = o1.toString();
		String s2 = o1.toString();
		int i1 = s1.length();
		int i2 = s2.length();
		if (i1 < i2) {
			return -1;
		} else if (i1 > i2) {
			return 1;
		} else {
			return 0;
		}

	}

}
