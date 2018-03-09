package com.library.action;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.hibernate.TypeMismatchException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
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

import com.library.constants.ResponseType;
import com.library.exceptionHandling.ErrorInfo;
import com.library.exceptionHandling.GloabalExceptions;
import com.library.model.Book;
import com.library.responsebean.LoanResponse;
import com.library.responsebean.RootResponse;
import com.library.service.IBookLoanService;

@RestController
public class BookLoanController {

	@Autowired
	private IBookLoanService bookLoanService;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/api/assignBook", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RootResponse<String> assignBookToStudent(@RequestParam(value = "bookId") int bookId,
			@RequestParam("studentId") int studentId) throws NoSuchMessageException, GloabalExceptions {
		if (bookLoanService.bookAssigned(bookId, studentId)) {
			return new RootResponse<String>(ResponseType.SUCCESS,
					messageSource.getMessage("book.successfully.issued", null, Locale.US));
		} else {
			return new RootResponse<String>(ResponseType.INFO,
					messageSource.getMessage("notsuccessfully.book.issued", null, Locale.US));
		}
	}

	@RequestMapping(value = "/api/unassignBook", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RootResponse<String> unAssignBook(@RequestParam("bookId") int bookId,
			@RequestParam("studentId") int studentId) throws NoSuchMessageException, GloabalExceptions {
		if (bookLoanService.bookUnAssigned(bookId, studentId)) {
			return new RootResponse<String>(ResponseType.SUCCESS,
					messageSource.getMessage("successfully.book.return", null, Locale.US));
		} else {
			return new RootResponse<String>(ResponseType.INFO,
					messageSource.getMessage("notsuccessfully.book.return", null, Locale.US));
		}
	}
	@RequestMapping(value = "/api/assignedBooks", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody RootResponse<List<LoanResponse>> getBooksAssigned(@RequestParam("studentId") int studentId)
			throws NoSuchMessageException, GloabalExceptions {
		return new RootResponse<List<LoanResponse>>(ResponseType.SUCCESS,
				bookLoanService.getBooksIssuedPerStudent(studentId));
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getAllBooks()
			throws NoSuchMessageException, GloabalExceptions, IOException, ParseException {
		List<Book> listOfBooks = bookLoanService.getAllBooksWithCount();

		JSONObject mainObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		for (Book book : listOfBooks) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("bookId", book.getBookId());
			jsonObject.put("bookName", book.getBookName());
			jsonObject.put("bookCategory", book.getCategory().getName());
			jsonObject.put("noOfBooksAvailable", book.getNoOfBooksAvailable());
			jsonObject.put("noOfBooksIssued", book.getNumberOfBooksIssued());
			jsonObject.put("publicaterName", book.getBookPublisherID().getPublisherName());
			jsonArray.add(jsonObject);
		}
		mainObject.put("Books", jsonArray);
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

}
