package com.library.service;

import java.util.List;

import com.library.exceptionHandling.GloabalExceptions;
import com.library.model.Book;

public interface IBookService {
	public List<Book> getAllBooks(int authorid, int page, int limit) throws GloabalExceptions;

	public int getTotalCountByAuthorId(int authorId);

}
