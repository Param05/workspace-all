package com.threadDemo;

public class PrimeGenerator extends Thread {

	@Override
	public void run() {
		long number = 1L;
		while (true) {
			if (isPrime(number)) {
				System.out.println("Number %d is prime"+ number);
				System.out.printf("Number %d is prime", number);
			}
			if (isInterrupted()) {
				System.out.printf("The prime generator has been interrupted");
				return;
			}
			number++;
		}
	}

	private boolean isPrime(long number) {
		if (number <= 2) {
			return true;
		}
		for (long i = 2; i < number; i++) {
			if ((number % i) == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		PrimeGenerator generator = new PrimeGenerator();
		Thread thread = new Thread(generator);
		thread.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}
		thread.interrupt();
	}
}
