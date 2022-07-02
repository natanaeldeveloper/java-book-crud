package io.github.natanaeldeveloper.controllers;

import javax.persistence.EntityManager;

import io.github.natanaeldeveloper.dao.BookDAO;
import io.github.natanaeldeveloper.models.Book;
import io.github.natanaeldeveloper.utils.JPAConnection;

public class BookController {
	
	private BookDAO bookDAO;
	public Book book;
	
	public BookController () {
		this.bookDAO = new BookDAO(JPAConnection.getEntityManager());
	}

	public Book createBook(String title, String author) {
		
		this.book = new Book();
		this.book.setTitle(title);
		this.book.setAuthor(author);
		
		try {
			return this.bookDAO.create(this.book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Book getBook(long id) {
		try {
			this.book = this.bookDAO.get(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.book;
	}
}
