package com.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	protected BlockingQueue<String> queue = null;
	public Producer(BlockingQueue<String> blockingQueue) {
		this.queue = blockingQueue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 8; i++) {
			System.out.println("tryting to add in the queue" + i
					+ "and the result " + queue.offer("String" + i));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}
	}
}
