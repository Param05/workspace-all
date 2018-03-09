package com.futureTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FactorialDemo {
	private static final ExecutorService executor = Executors
			.newFixedThreadPool(2);

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		FactorialCalculator calculator = new FactorialCalculator(3);
		System.out.println("submitting task");
		Future<Long> future = executor.submit(calculator);
		while (!future.isDone()) {
			System.out.println("Task is not completed yett!!!!");
			Thread.sleep(1);
		}
		System.out.println("Task is completed ");
		Long result = future.get();
		System.out.println("factorial is " + result);
		executor.shutdown();
	}
}
