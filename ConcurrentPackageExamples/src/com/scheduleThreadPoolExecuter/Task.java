package com.scheduleThreadPoolExecuter;

import java.util.Date;

public class Task implements Runnable {

	private String name;
	byte b = 127;

	public Task(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public void run() {
		System.out.println(b);
		try {
			System.out.println("Doing a task during : " + name + " - Time - "
					+ new Date());
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
