package com.library.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.library.constants.Master;
import com.library.model.Book;

public class GetDetails {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public boolean getAuthorID(int authorid) {
		Session session = sessionFactory.openSession();
		boolean result = false;
		Query query = session.createQuery(Master.GET_ALL_AUTHROID);
		List<Book> bookList = query.list();
		for (Book book : bookList) {
			if (authorid == book.getAuthor().getAuthorId()) {
				result = true;
			} else {
				result = false;
			}

		}
		return result;
	}

}
