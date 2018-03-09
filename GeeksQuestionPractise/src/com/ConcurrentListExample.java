package com;

public class ConcurrentListExample {

	public static void main(String[] args) {
		Integer integer = new Integer(10);
		Integer integer2 = integer;
		Integer integer3 = new Integer(10);
		System.out.println(integer == integer2);
		System.out.println(integer == integer3);
		System.out.println(integer.equals(integer2));

	}
}