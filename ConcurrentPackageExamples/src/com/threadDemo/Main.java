package com.threadDemo;

public class Main {
	public static void main(String[] args) {

		Thread thread = new PrimeGenerator();
		thread.start();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}
}
