package com.countDownCatch;

import java.util.concurrent.CountDownLatch;

public class Demo {
	public static void main(String[] args) {

		final CountDownLatch countDownLatch = new CountDownLatch(3);
		Thread cashThread = new Thread(new Service("CashService", 1000,
				countDownLatch));
		Thread alertThread = new Thread(new Service("alertService", 1000,
				countDownLatch));
		Thread validationThread = new Thread(new Service("validationService",
				1000, countDownLatch));

		cashThread.start();
		alertThread.start();
		validationThread.start();
		try {
			countDownLatch.await();
			System.out
					.println("All Service is up now u can write the logic here ");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
