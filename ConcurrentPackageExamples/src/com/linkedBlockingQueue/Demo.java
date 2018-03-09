package com.linkedBlockingQueue;

import java.util.concurrent.LinkedBlockingQueue;

public class Demo {
	public static void main(String[] args) {
		LinkedBlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(
				10);
		Producer producer = new Producer(blockingQueue);
		ObserverConsumer observerConsumer = new ObserverConsumer(blockingQueue,
				producer);
		RemoveConsumer removeConsumer = new RemoveConsumer(blockingQueue,
				producer);

		new Thread(producer).start();
		new Thread(observerConsumer).start();
		new Thread(removeConsumer).start();

	}
}
