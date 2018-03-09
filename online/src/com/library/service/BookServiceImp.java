package com.library.service;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.library.dao.IBookDao;
import com.library.exceptionHandling.GloabalExceptions;
import com.library.model.Book;

@Service
public class BookServiceImp implements IBookService {

	@Autowired
	private IBookDao bookDao;

	@Autowired
	private MessageSource messageSource;

	@Override
	public List<Book> getAllBooks(int authorid, int page, int limit) throws GloabalExceptions {

		if (page <= 0 || limit <= 0) {
			throw new GloabalExceptions(this.messageSource.getMessage("pageOrLimit", null, Locale.US));
		}
		List<Book> listOfBook = bookDao.getAllBook(authorid, page, limit);
		if (listOfBook == null) {
			throw new GloabalExceptions(this.messageSource.getMessage("nomorebook", null, Locale.US));
		}

		return listOfBook;
	}

	@Override
	public int getTotalCountByAuthorId(int authorId) {
		return bookDao.getTotalBookCountByAuthor(authorId);

	}

}
