package com.library.dao;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Repository;

import com.library.constants.Master;
import com.library.exceptionHandling.GloabalExceptions;
import com.library.model.Book;

@Repository
public class BookDaoImp implements IBookDao{

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private GetDetails getDetails;

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getAllBook(int authorid, int page, int limit) throws NoSuchMessageException, GloabalExceptions {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(Master.FETCH_BOOKS);
		query.setParameter("authorid", authorid);
		int firstResult = (page * limit) - limit;
		query.setFirstResult(firstResult);
		query.setMaxResults(limit);
		boolean result = getDetails.getAuthorID(authorid);
		List<Book> bookList = query.list();
		if ((bookList != null) && (bookList.size() > 0)) {
			return bookList;
		} else if (result) {
			throw new GloabalExceptions(this.messageSource.getMessage("nomorebook", null, Locale.US));
		} else {
			throw new GloabalExceptions(this.messageSource.getMessage("authorNotFound", null, Locale.US));
		}
	}

	public int getTotalBookCountByAuthor(final int authorId) {

		Query query = sessionFactory.openSession().createQuery(Master.COUNT_NUMBER_OF_BOOKS);
		
		query.setParameter("authorId", authorId);
		Long result = (Long) query.list().get(0);
		return result.intValue();
	}

}
