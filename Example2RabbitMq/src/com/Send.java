package com;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

public class Send {

	{
		System.out.println("hi initializer");
	}

	public Send() {
		System.out.println("cons");
	}

	static {
		System.out.println("hii static");
	}

	private final static String TASK_QUEUE_NAME = "hello";

	private static String getMessage(String[] strings) {
		if (strings.length < 1)
			return "Hello World!";
		return joinStrings(strings, " ");
	}

	private static String joinStrings(String[] strings, String delimiter) {

		int length = strings.length;
		if (length == 0)
			return "";
		StringBuilder words = new StringBuilder(strings[0]);
		for (int i = 1; i < length; i++) {
			words.append(delimiter).append(strings[i]);
		}
		return words.toString();
	}

	public static void main(String[] argv) throws Exception {
		Send send=new Send();

		// ConnectionFactory factory = new ConnectionFactory();
		// factory.setHost("localhost");
		// Connection connection = factory.newConnection();
		// Channel channel = connection.createChannel();
		//
		// channel.queueDeclare(TASK_QUEUE_NAME, false, false, false, null);
		// String message = getMessage(argv);
		// channel.basicPublish("", TASK_QUEUE_NAME,
		// MessageProperties.PERSISTENT_TEXT_PLAIN,
		// message.getBytes("UTF-8"));
		// System.out.println(" [x] Sent '" + message + "'");
		//
		// channel.close();
		// connection.close();
	}

}
