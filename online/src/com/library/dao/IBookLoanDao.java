package com.library.dao;

import java.util.List;

import org.springframework.context.NoSuchMessageException;

import com.library.exceptionHandling.GloabalExceptions;
import com.library.model.Book;
import com.library.model.Loan;

public interface IBookLoanDao {
	public boolean updateBookDetailsAsPerTheStudent(int studentId, int bookId)
			throws NoSuchMessageException, GloabalExceptions;

	public boolean updateUnAssignedBooks(int studentID, int bookId) throws NoSuchMessageException, GloabalExceptions;

	public List<Loan> getBooksPerStudent(int studentId) throws NoSuchMessageException, GloabalExceptions;

	public List<Book> getAssignedAndUnAssignedBooks();

}
