package com.linkedBlockingQueue;

import java.util.concurrent.LinkedBlockingQueue;

public class ObserverConsumer implements Runnable {

	private LinkedBlockingQueue<String> blockingQueue;
	private Producer producer;

	public ObserverConsumer(LinkedBlockingQueue<String> blockingQueue,
			Producer producer) {
		this.blockingQueue = blockingQueue;
		this.producer = producer;
	}

	@Override
	public void run() {
		while (producer.isRunning()) {
			System.out.println("observer consuming " + blockingQueue);
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("OC is completed");
		System.out.println("Final elements in the queue: " + blockingQueue);

	}
}
