package com.library.dao;

import java.util.List;

import com.library.model.Loan;

public interface IDownloadStudentLoanBooksDao {
	public List<Loan> getBooksLoanBorrowedByStudents();
}
