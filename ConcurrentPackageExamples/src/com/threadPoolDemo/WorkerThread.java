package com.threadPoolDemo;

public class WorkerThread implements Runnable {

	private String command;

	public WorkerThread(String string) {
		this.command = string;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()
				+ " Start. Command = " + command);
		processCommand();
		System.out.println(Thread.currentThread().getName() + " End.");
	}

	private void processCommand() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
