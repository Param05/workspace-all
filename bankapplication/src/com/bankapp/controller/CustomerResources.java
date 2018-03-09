package com.bankapp.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.Customer;
import com.bankapp.service.ICustomerService;

@RestController
// @RestController=@Controller + @ResponseBody
public class CustomerResources {

	@Autowired
	private ICustomerService service;

	@RequestMapping(value = "/api/customer", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Customer> getAllBooks() {
		Collection<Customer> customer = service.getAllCustomer();
		return customer;
	}

	/*
	 * @RequestMapping(value = "/api/book/{id}", method = RequestMethod.GET,
	 * produces = MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<Book>
	 * getAnBook(@PathVariable Integer id) { Book book =
	 * service.getBookById(id); if (book == null) { return new
	 * ResponseEntity<Book>(HttpStatus.NOT_FOUND); }
	 * 
	 * return new ResponseEntity<Book>(book, HttpStatus.OK); }
	 * 
	 * @RequestMapping(value = "/api/book", method = RequestMethod.POST,
	 * consumes = MediaType.APPLICATION_JSON_VALUE, produces =
	 * MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<Book>
	 * createBook(@RequestBody Book book) { Book savedBook =
	 * service.addBook(book); return new ResponseEntity<Book>(savedBook,
	 * HttpStatus.CREATED); }
	 * 
	 * @RequestMapping(value = "/api/book/{id}", method = RequestMethod.PUT,
	 * consumes = MediaType.APPLICATION_JSON_VALUE, produces =
	 * MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<Book>
	 * updateBook(@PathVariable Integer id,
	 * 
	 * @RequestBody Book book) {
	 * 
	 * service.updateBook(book);
	 * 
	 * return new ResponseEntity<Book>(HttpStatus.OK); }
	 * 
	 * @RequestMapping(value = "/api/book/{id}", method = RequestMethod.DELETE)
	 * public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id)
	 * throws Exception {
	 * 
	 * service.removeBook(id); return new
	 * ResponseEntity<Book>(HttpStatus.NO_CONTENT); }
	 */
}