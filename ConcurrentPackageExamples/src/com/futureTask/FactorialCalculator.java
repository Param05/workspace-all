package com.futureTask;

import java.util.concurrent.Callable;

public class FactorialCalculator implements Callable<Long> {
	private int i;

	public FactorialCalculator(int i) {
		super();
		this.i = i;
	}

	@Override
	public Long call() throws Exception {
		long output = 0;
		try {
			output = factorial(i);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return output;
	}

	private long factorial(int number) throws InterruptedException {
		if (number < 0) {
			throw new IllegalArgumentException(
					"Number must be greater than zero");
		}
		long result = 1;
		while (number > 0) {
			Thread.sleep(100); // adding delay for example
			result = result * number;
			number--;
		}
		return result;
	}

}
