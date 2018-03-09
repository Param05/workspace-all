package com;

import java.util.HashSet;
import java.util.SortedSet;

public class HashSetDemo {
	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<>();
		hashSet.add("a");
		hashSet.add("b");
		hashSet.add("d");
		hashSet.add("c");
		System.out.println(hashSet);
	}
}
