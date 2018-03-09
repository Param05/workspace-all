package com.demo;

import javax.ejb.ActivationConfigProperty;


import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.inventory.persistence.Product;
import com.jmsdemo.Customer;

//@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "age > 20 AND name LIKE 'R%'") })
@MessageDriven(mappedName = "myDestination/JMS_Resource", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class ConsumerBean implements MessageListener {
	Customer customer = null;

	public void onMessage(Message message) {

		/*
		 * if (message instanceof TextMessage) { TextMessage tMessage =
		 * (TextMessage) message; try { System.out.println("got:" +
		 * tMessage.getText()); } catch (JMSException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } }
		 * 
		 * if (message instanceof MapMessage) { MapMessage tMessage =
		 * (MapMessage) message; try { System.out.println("got:" +
		 * tMessage.getInt("age"));
		 * 
		 * } catch (JMSException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		if (message instanceof ObjectMessage) {
			Product productObjectessage;
			try {
				productObjectessage = (Product) ((ObjectMessage) message)
						.getObject();
				System.out.println("got:"
						+ productObjectessage.getProductName());

			} catch (JMSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
