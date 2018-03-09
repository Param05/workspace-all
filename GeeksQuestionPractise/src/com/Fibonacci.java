package com;

public class Fibonacci {
	public static void main(String[] args) {

		int fibcount = 15;
		int n[] = new int[fibcount];
		n[0] = 0;
		n[1] = 1;

		for (int i = 2; i < fibcount; i++) {
			n[i] = n[i - 1] + n[i - 2];
		}
		for (int i = 0; i < fibcount; i++) {
			System.out.println(n[i] + "");

		}

	}
}
