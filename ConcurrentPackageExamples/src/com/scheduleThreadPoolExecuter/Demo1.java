package com.scheduleThreadPoolExecuter;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Demo1 {
	public static void main(String[] args) {
		ScheduledExecutorService executorService = Executors
				.newScheduledThreadPool(1);
		Task task = new Task("Demo task 1");
		System.out.println("The time is " + new Date());
		ScheduledFuture<?> result = executorService.scheduleAtFixedRate(task,
				2, 5, TimeUnit.SECONDS);
		System.out.println("system " + result);
		try {
			TimeUnit.MINUTES.sleep(200);
		} catch (Exception e) {
			e.printStackTrace();
		}
		executorService.shutdown();
	}
}
