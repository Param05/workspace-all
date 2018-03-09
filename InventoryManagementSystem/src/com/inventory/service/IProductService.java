package com.inventory.service;

import java.util.List;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;

import com.inventory.persistence.Product;

public interface IProductService {

	public List<Product> getAllProducts();

	public void addProduct(Product product);

	public Product getProductById(int id);

	public void updateProduct(Product product);

	public void removeProduct(int id);
	
	public void sendProductToJMS(ConnectionFactory connectionFactory,Destination destination,Product product);

}
