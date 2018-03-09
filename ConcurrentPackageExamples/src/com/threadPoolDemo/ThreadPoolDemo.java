package com.threadPoolDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolDemo {
	public static void main(String[] args) {

		ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {

			Runnable runnable = new WorkerThread("" + i);
			executorService.submit(runnable);
		}
	}
}
