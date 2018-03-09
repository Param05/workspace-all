package com;

import java.util.Scanner;

public class FindNumber {

	public static boolean number(int a) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] numbers = new int[n];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = scanner.nextInt();
		}

		System.out.println(numbers);
		for (int i = 1; i < numbers.length - 1; i++) {
			if (numbers[i] == a) {
				System.out.println("YEs");
				return true;
			} else {
			}

		}

		return false;
	}

	public static void main(String[] args) {
		number(5);
	}
}
