package com.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class Demo {
	public static void main(String[] args) {
		final CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
			

			@Override
			public void run() {
				System.out
						.println("all parties are arrived at barrier lets play");
			}
		});
		Thread thread = new Thread(new Task(barrier), "Thread 1");
		Thread thread2 = new Thread(new Task(barrier), "Thread 2");
		Thread thread3 = new Thread(new Task(barrier), "Thread 3");

		thread.start();
		thread2.start();
		thread3.start();

	}
}
