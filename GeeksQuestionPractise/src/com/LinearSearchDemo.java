package com;

import java.util.Scanner;

public class LinearSearchDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int array[] = new int[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}
		System.out.println("find array number");
		int findNumber = scanner.nextInt();
		System.out.println(findNumber(array, array.length, findNumber));
		scanner.close();

	}

	private static int findNumber(int[] array, int length, int findNumber) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == findNumber) {
				return i;
			}
		}
		return -1;
	}
}
