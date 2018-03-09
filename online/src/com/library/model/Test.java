package com.library.model;

import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

public class Test {

	ThreadPoolExecutor executer = (ThreadPoolExecutor) Executors.newCachedThreadPool();
	ThreadPoolExecutor execute1r = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
	ExecutorService executor = Executors.newSingleThreadExecutor();
	ScheduledExecutorService executor111 = Executors.newScheduledThreadPool(5);
}
