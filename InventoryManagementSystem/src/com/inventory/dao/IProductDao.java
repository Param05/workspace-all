package com.inventory.dao;

import java.util.List;

import com.inventory.persistence.Product;

public interface IProductDao {

	public List<Product> getAllProducts();

	public void addProduct(Product product);

	public Product getProductById(int id);

	public void updateProduct(Product product);

	public void removeProduct(int id);

}
