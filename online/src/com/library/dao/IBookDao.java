package com.library.dao;

import java.util.List;

import org.springframework.context.NoSuchMessageException;

import com.library.exceptionHandling.GloabalExceptions;
import com.library.model.Book;

public interface IBookDao {
	public List<Book> getAllBook(int id, int page, int limit) throws NoSuchMessageException, GloabalExceptions;

	public int getTotalBookCountByAuthor(final int authorId);

}
