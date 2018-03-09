package com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListIterator {
	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<>();
		for (int i = 0; i < 10; i++)
			ints.add(i);
		System.out.println(ints);
		Iterator<Integer> it = ints.iterator();

		while (it.hasNext()) {
			System.out.println("");
			int x = (int) it.next();
			if (x % 2 == 0) {
				ints.remove(0);
				System.out.println(ints);
			}
		}
		System.out.println(ints);
	}
}
