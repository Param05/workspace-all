package com.library.service;

import java.util.List;

import org.springframework.context.NoSuchMessageException;

import com.library.exceptionHandling.GloabalExceptions;
import com.library.model.Book;
import com.library.responsebean.LoanResponse;

public interface IBookLoanService {

	public boolean bookAssigned(int bookId, int studentId) throws NoSuchMessageException, GloabalExceptions;

	public boolean bookUnAssigned(int bookId, int studentId) throws NoSuchMessageException, GloabalExceptions;

	public List<LoanResponse> getBooksIssuedPerStudent(int studentId) throws NoSuchMessageException, GloabalExceptions;

	public List<Book> getAllBooksWithCount();

}
