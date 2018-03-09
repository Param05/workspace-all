package com;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = { 38, 27, 43, 3, 9, 82, 10 };

		sort(arr, 0, arr.length - 1);
	}

	private static void sort(int arr[], int i, int length) {
		if (i < length) {
			int middle = (i + length) / 2;
			sort(arr, i, middle);
			sort(arr, middle + 1, i);
			System.out.println("\nSorted array");
			printArray(arr);
			merge(arr, i, middle, length);
		}
	}

	private static void merge(int[] arr, int i, int middle, int length) {

	}

	private static void printArray(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();

	}
}
