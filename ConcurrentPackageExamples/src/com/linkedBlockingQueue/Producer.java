package com.linkedBlockingQueue;

import java.util.concurrent.LinkedBlockingQueue;

public class Producer implements Runnable {

	private LinkedBlockingQueue<String> blockingQueue;
	private boolean running;

	public Producer(LinkedBlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
		running = true;
	}

	public boolean isRunning() {
		return running;
	}

	@Override
	public void run() {
		for (int i = 0; i < 8; i++) {
			String element = "String" + i;

			try {
				blockingQueue.put(element);
				System.out.println("P\tAdding element" + element);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		}
		System.out.println("p is completed");
		running = false;
	}
}
