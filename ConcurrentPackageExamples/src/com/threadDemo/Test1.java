package com.threadDemo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;

public class Test1 implements Runnable {

	private int number;

	public Test1(int number) {
		this.number = number;
	}

	public static void main(String[] args) throws IOException {

		Thread[] thread = new Thread[10];
		Thread.State status[] = new Thread.State[10];

		for (int i = 0; i < 10; i++) {
			thread[i] = new Thread(new Test1(i));
			if ((i % 2) == 0) {
				thread[i].setPriority(Thread.MAX_PRIORITY);
			} else {
				thread[i].setPriority(Thread.MIN_PRIORITY);
			}
			thread[i].setName("Thread 	 " + i);

		}
		try (FileWriter file = new FileWriter("E:/workspace/ConcurrentPackageExamples/src/com/os.txt");
				PrintWriter pw = new PrintWriter(file);) {
			for (int i = 0; i < 10; i++) {
				pw.println("Main : Status of Thread " + i + " : "
						+ thread[i].getState());
				status[i] = thread[i].getState();
			}
			for (int i = 0; i < 10; i++) {
				thread[i].start();
			}

			boolean finish = false;
			while (!finish) {
				for (int i = 0; i < 10; i++) {
					if (thread[i].getState() != status[i]) {
						writeThreadInfo(pw, thread[i], status[i]);
						status[i] = thread[i].getState();
					}
				}
				finish = true;
				for (int i = 0; i < 10; i++) {
					finish = finish
							&& (thread[i].getState() == State.TERMINATED);
				}
			}
			for (int i = 0; i < 10; i++) {
				thread[i].start();
			}

		}
	}

	private static void writeThreadInfo(PrintWriter pw, Thread thread,
			State state) {
		pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
		pw.printf("Main : Priority: %d\n", thread.getPriority());
		pw.printf("Main : Old State: %s\n", state);
		pw.printf("Main : New State: %s\n", thread.getState());
		pw.printf("Main : ************************************\n");
	}

	@Override
	public void run() {
		for (int j = 0; j < 10; j++) {
			System.out.printf("%s: %d * %d = %d\n", Thread.currentThread()
					.getName(), number, j, j * number);
		}
	}
}
