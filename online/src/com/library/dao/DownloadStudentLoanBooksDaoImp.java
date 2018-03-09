package com.library.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.constants.Master;
import com.library.model.Loan;

@Repository
public class DownloadStudentLoanBooksDaoImp implements IDownloadStudentLoanBooksDao {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Loan> getBooksLoanBorrowedByStudents() {
		Query query = sessionFactory.getCurrentSession().createQuery(Master.BORROWED_BOOKS);

		return query.list();
	}

}
