package com.scheduleThreadPoolExecuter;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Demo {
	public static void main(String[] args) {
		ScheduledExecutorService executorService = Executors
				.newScheduledThreadPool(2);
		Task task = new Task("task1");
		Task task1 = new Task("task2");

		System.out.println("The time is" + new Date());

		executorService.schedule(task, 1, TimeUnit.MINUTES);
		executorService.schedule(task1, 3, TimeUnit.MINUTES);

	}
}
