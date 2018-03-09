package com.inventory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.inventory.persistence.Product;
import com.inventory.util.DbUtil;

public class ProductDaoImp implements IProductDao {
	private Connection connection = null;
	private Product product = null;

	public ProductDaoImp() {

	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> productlist = new ArrayList<Product>();
		try {
			connection = DbUtil.getConnection();
			Statement statement = connection.createStatement();

			ResultSet rs = statement
					.executeQuery("select * from product");
			while (rs.next()) {
				product = new Product();
				product.setProductName(rs.getString("product_name"));
				product.setProductDescription(rs
						.getString("product_description"));
				product.setProductPrice(rs.getDouble("product_price"));
				productlist.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productlist;
	}

	@Override
	public void addProduct(Product product) {
		try {
			connection = DbUtil.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into product(product_name,product_description,product_price) values (?, ?, ? )");
			preparedStatement.setString(1, product.getProductName());
			preparedStatement.setString(2, product.getProductDescription());
			preparedStatement.setDouble(3, product.getProductPrice());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

}
