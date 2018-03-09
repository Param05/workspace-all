package com.library.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.IDownloadStudentLoanBooksDao;
import com.library.model.Loan;

@Service
public class DownloadServiceImp implements IDownloadService {

	@Autowired
	private IDownloadStudentLoanBooksDao iDownloadStudentBorrowedDao;

	@Override
	@Transactional
	public List<Loan> getBooksBorrowedDetailsInExcel() {
		List<Loan> listOfBook = iDownloadStudentBorrowedDao.getBooksLoanBorrowedByStudents();
		return listOfBook;
	}
}
