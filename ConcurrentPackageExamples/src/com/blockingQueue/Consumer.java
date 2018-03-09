package com.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	protected BlockingQueue<String> queue = null;

	public Consumer(BlockingQueue<String> blockingQueue) {
		this.queue = blockingQueue;
	}

	@Override
	public void run() {
		while (queue.remainingCapacity() > 0) {
			System.out.println("Queue size is" + queue.size() + ","
					+ "remaining capacity" + queue.remainingCapacity());
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
