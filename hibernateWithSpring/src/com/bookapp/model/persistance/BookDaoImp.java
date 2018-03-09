package com.bookapp.model.persistance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImp implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Book> getAllBooks() {
		// return em.
		return null;
	}

	@Override
	public Book getBookById(int bookId) {
		// return em.find(Book.class, bookId);
		return null;
	}

	@Override
	public Book addBook(Book book) {
		getSession().save(book);// session.save() em.persist()
		// em.flush();
		return book;
	}

	@Override
	public Book updateBook(Book book) {
		// return em.merge(book);
		return null;
	}

	@Override
	public Book removeBook(int bookId) {
		/*
		 * Book book = em.find(Book.class, bookId); if (book != null)
		 * em.remove(bookId); return book;
		 */
		return null;
	}

}