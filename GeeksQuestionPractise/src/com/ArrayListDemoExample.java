package com;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemoExample {
	public static void main(String[] args) {
		List<String> letters = new ArrayList<String>();

		// add example
		letters.add("A");
		letters.add("C");
		letters.add("D");

		// let's insert B between A and C
		letters.add(1, "B");
		System.out.println(letters);

		List<String> list = new ArrayList<String>();
		list.add("E");
		list.add("H");

		// appending list elements to letters
		letters.addAll(list);
		System.out.println(letters);

		list.clear();
		System.out.println(list);// clear the list but not letters
		System.out.println(letters);

		list.add("F");
		list.add("G");

		letters.addAll(5, list);
		System.out.println(letters);
	}
}
