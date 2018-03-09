package com.library.service;

import java.util.List;

import com.library.model.Loan;

public interface IDownloadService {
	public List<Loan> getBooksBorrowedDetailsInExcel();
}
