package com.countDownCatch;

import java.util.concurrent.CountDownLatch;

public class Service implements Runnable {

	private final String name;
	private final int timeToStart;
	private final CountDownLatch countDownLatch;

	public Service(String name, int timeToStart, CountDownLatch countDownLatch) {
		this.name = name;
		this.countDownLatch = countDownLatch;
		this.timeToStart = timeToStart;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(timeToStart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(name + "is up ");
		countDownLatch.countDown();

	}
}
