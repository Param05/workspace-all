/*package com.demo;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.jmsdemo.Customer;

@Singleton
@LocalBean
@Startup
public class Tester {

	@Resource(name = "myConnectionJNNDI")
	private ConnectionFactory connectionFactory;

	@Resource(name = "myDestination/JMS_Resource")
	private Destination destination;
	Customer customer = null;

	public Tester() {

	}

	@PostConstruct
	public void Producter() {
		Connection connection = null;
		try {

			connection = connectionFactory.createConnection();
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(destination);

			TextMessage message = session
					.createTextMessage("Created an message!!!");
			producer.send(message);
			System.out.println("++++++++++++++++++++++++++"
					+ customer.getName());
			System.out.println("Message send.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
*/