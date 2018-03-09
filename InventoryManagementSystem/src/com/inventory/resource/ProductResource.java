package com.inventory.resource;

import java.util.List;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.inventory.persistence.Product;
import com.inventory.service.IProductService;
import com.inventory.service.ProductServiceImp;

@Path("/product")
public class ProductResource {
	private IProductService iProductService = new ProductServiceImp();

	@Resource(name = "myConnectionJNNDI")
	private ConnectionFactory connectionFactory;

	@Resource(name = "myDestination/JMS_Resource")
	private Destination destination;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProducts() {
		return iProductService.getAllProducts();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void addProduct(Product product) {

		iProductService.addProduct(product);
		iProductService.sendProductToJMS(connectionFactory, destination, product);
	}
}
