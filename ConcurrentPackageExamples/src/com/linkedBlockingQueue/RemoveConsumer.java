package com.linkedBlockingQueue;

import java.util.concurrent.LinkedBlockingQueue;

public class RemoveConsumer implements Runnable {
	private LinkedBlockingQueue<String> blockingQueue;
	private Producer producer;

	public RemoveConsumer(LinkedBlockingQueue<String> blockingQueue,
			Producer producer) {
		this.blockingQueue = blockingQueue;
		this.producer = producer;
	}

	@Override
	public void run() {

		while (producer.isRunning()) {
			try {
				System.out
						.println("remove consuming " + blockingQueue.take());
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		System.out.println("rc is completed");
	}

}
