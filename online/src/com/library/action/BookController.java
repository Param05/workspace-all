package com.library.action;

import java.io.IOException;

import java.util.Collection;
import java.util.Locale;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.hibernate.TypeMismatchException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.exceptionHandling.ErrorInfo;
import com.library.exceptionHandling.GloabalExceptions;
import com.library.model.Book;
import com.library.service.IBookService;

@RestController
public class BookController {

	@Autowired
	private IBookService bookService;
	@Autowired
	private MessageSource messageSource;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/api/book", method = RequestMethod.GET, params = { "page",
			"limit" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String findByBookAuthor(@RequestParam("page") int page, @RequestParam("limit") int limit,
			@RequestParam("authorid") int authorid)
			throws GloabalExceptions, JsonGenerationException, JsonMappingException, IOException {
		Collection<Book> books = bookService.getAllBooks(authorid, page, limit);
		JSONObject mainObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		for (Book book : books) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("bookId", book.getBookId());
			jsonObject.put("bookName", book.getBookName());
			jsonObject.put("bookCategory", book.getCategory().getName());
			jsonObject.put("noOfBooksAvailable", book.getNoOfBooksAvailable());
			jsonObject.put("publicaterName", book.getBookPublisherID().getPublisherName());
			jsonArray.add(jsonObject);
		}
		mainObject.put("Books", jsonArray);
		mainObject.put("totalCount", bookService.getTotalCountByAuthorId(authorid));
		return mainObject.toJSONString();
	}

	@ExceptionHandler({ MissingServletRequestParameterException.class, TypeMismatchException.class })
	public ResponseEntity<ErrorInfo> handleMissingParams(Exception exception) {

		ErrorInfo error = new ErrorInfo();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		if (exception instanceof MissingServletRequestParameterException) {
			MissingServletRequestParameterException missingServletRequestParameterException = (MissingServletRequestParameterException) exception;
			error.setMessage(messageSource.getMessage("error.validation.parameter.missing",
					new String[] { missingServletRequestParameterException.getParameterName() }, Locale.US));

		} else if (exception instanceof TypeMismatchException) {
			error.setMessage(messageSource.getMessage("error.validation.parameter.typemissmatch", null, Locale.US));

		}
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.OK);
	}

	public static void main(String[] args) {
	}
}
