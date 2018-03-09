package com.inventory.service;

import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import com.inventory.dao.IProductDao;
import com.inventory.dao.ProductDaoImp;
import com.inventory.persistence.Product;

public class ProductServiceImp implements IProductService {

	IProductDao productDao = new ProductDaoImp();

	@Override
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	@Override
	public void addProduct(Product product) {

		productDao.addProduct(product);

	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeProduct(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendProductToJMS(ConnectionFactory connectionFactory,
			Destination destination, Product product) {
		try {
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(destination);
			ObjectMessage object = session.createObjectMessage(product);
			producer.send(object);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
