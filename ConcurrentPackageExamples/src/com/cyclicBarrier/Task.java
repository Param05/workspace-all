package com.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class Task implements Runnable {
	private CyclicBarrier barrier;

	public Task(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName()
					+ "is waiting on bariere");
			barrier.await();
			System.out.println(Thread.currentThread().getName() + "has crossed");
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}
}
