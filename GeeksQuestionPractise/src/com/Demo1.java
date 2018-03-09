package com;

import java.util.Scanner;

public class Demo1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] numbers = new int[n];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = scanner.nextInt();
		}
		n = 2;

		leftRotation(numbers, numbers.length, n);
		printArray(numbers);

		int result = maximumNumber(numbers, numbers.length, n);
		System.out.println(result);
		scanner.close();
	}

	private static void leftRotation(int[] numbers, int length, int d) {

		for (int i = 0; i < d; i++) {
			int k, temp;
			temp = numbers[0];
			for (k = 0; k < length - 1; k++) {
				numbers[k] = numbers[k + 1];
			}
			numbers[k] = temp;

		}
	}

	private static void printArray(int number[]) {
		for (int i = 0; i < number.length; i++) {
			System.out.println(number[i] + " ");

		}

	}

	private static int maximumNumber(int[] numbers, int length, int n) {

		int max = numbers[0];
		int result = 0;
		for (int i = 0; i < n; i++)
			numbers[(numbers[i] % n)] += n;

		for (int j = 1; j < n; j++) {
			if (numbers[j] > max) {
				max = numbers[j];
				result = j;
			}
		}
		return result;

	}
}
