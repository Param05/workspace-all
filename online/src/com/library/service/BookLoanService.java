package com.library.service;

import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.dao.IBookLoanDao;
import com.library.exceptionHandling.GloabalExceptions;
import com.library.model.Book;
import com.library.model.Loan;
import com.library.responsebean.LoanResponse;

@Service
public class BookLoanService extends Object implements IBookLoanService {

	@Autowired
	private IBookLoanDao bookLoanDao;

	@Override
	@Transactional
	public boolean bookAssigned(int bookId, int studentId) throws NoSuchMessageException, GloabalExceptions {
		return bookLoanDao.updateBookDetailsAsPerTheStudent(studentId, bookId);
	}

	@Override
	@Transactional
	public boolean bookUnAssigned(int bookId, int studentId) throws NoSuchMessageException, GloabalExceptions {
		return bookLoanDao.updateUnAssignedBooks(studentId, bookId);
	}

	@Override
	@Transactional
	public List<LoanResponse> getBooksIssuedPerStudent(int studentId) throws NoSuchMessageException, GloabalExceptions {
		List<Loan> loan = bookLoanDao.getBooksPerStudent(studentId);
		List<LoanResponse> bookResponses = new ArrayList<>();
		for (Loan loans : loan) {
			bookResponses.add(new LoanResponse(loans));
		}
		return bookResponses;

	}

	@Override
	@Transactional
	public List<Book> getAllBooksWithCount() {
		List<Book> books = bookLoanDao.getAssignedAndUnAssignedBooks();

		for (Book book : books) {
			int countofbooks = 0;
			for (Loan loan : book.getLoan()) {
				System.out.println(loan.getDateOfIssue());
				System.out.println(loan.getStudent().getStudentFirstName());
				if (loan.isReturned == false) {
					countofbooks++;
					book.setNumberOfBooksIssued(countofbooks);
				}
			}
		}

		return books;
	}
}
