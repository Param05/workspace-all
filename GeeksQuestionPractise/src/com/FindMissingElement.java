package com;

public class FindMissingElement {
	public static int getMissingNo(int a[], int n) {
		int sumOfArray = 0;
		int sum = (n + 1) * (n + 2) / 2;

		for (int i = 0; i < n; i++) {
			sumOfArray += a[i];
		}
		int result = sum - sumOfArray;
		return result;
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 6, 7, 8 };
		int miss = getMissingNo(a, a.length);
		System.out.println(miss);
	}
}
