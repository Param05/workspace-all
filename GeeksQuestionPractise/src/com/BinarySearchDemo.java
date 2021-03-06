package com;

import java.util.Scanner;

public class BinarySearchDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int array[] = new int[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}
		System.out.println("number to found");
		int numberToFound = scanner.nextInt();
		binarySearch(array, 0, array.length - 1, numberToFound);

		scanner.close();
	}

	private static int binarySearch(int[] array, int initialElementForSearch,
			int length, int numberToFound) {
		int mid = initialElementForSearch + (length - 1) / 2;
		System.out.println(mid);
		if (array[mid] == numberToFound) {
			return mid;
		}
		if (array[mid] > numberToFound) {
			binarySearch(array, initialElementForSearch, mid - 1, numberToFound);
		}
		if (array[mid] < numberToFound) {
			binarySearch(array, mid + 1, length, numberToFound);
		}

		return -1;
	}
}
