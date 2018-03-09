package com.inventory.web.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inventory.persistence.Product;
import com.inventory.service.IProductService;
import com.inventory.service.ProductServiceImp;

public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IProductService iProductService;
	
	@Resource(name = "myConnectionJNNDI")
	private ConnectionFactory connectionFactory;

	@Resource(name = "myDestination/JMS_Resource")
	private Destination destination;

	
	public AddProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/jsp/addProduct.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Connection connection = null;
		Product product = new Product();
		iProductService = new ProductServiceImp();
		String productName = request.getParameter("productName");
		String productDescription = request.getParameter("productDescription");
		double productPrice = Double.parseDouble(request
				.getParameter("productPrice"));
		System.out.println(productName + "" + productDescription + ""
				+ productPrice);
		product.setProductName(productName);
		product.setProductDescription(productDescription);
		product.setProductPrice(productPrice);
		iProductService.addProduct(product);
		iProductService.sendProductToJMS(connectionFactory, destination, product);
		request.setAttribute("products", iProductService.getAllProducts());
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/jsp/showProduct.jsp");
		dispatcher.forward(request, response);
	}

}
