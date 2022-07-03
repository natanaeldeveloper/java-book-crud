package io.github.natanaeldeveloper.controllers;

import io.github.natanaeldeveloper.dao.BookDAO;
import io.github.natanaeldeveloper.models.Book;
import io.github.natanaeldeveloper.utils.JPAConnection;

public class BookController extends Controller{
	
	private BookDAO bookDAO;
	public Book book;
	
	public BookController () {
		this.bookDAO = new BookDAO(JPAConnection.getEntityManager());
		this.book = new Book();
	}

	public Book createBook(String title, String author) throws Exception {
		
		try {
			if(title.isEmpty())
				throw new Exception("O campo Título não foi informado");
			
			if(author.isEmpty())
				throw new Exception("O campo Author não foi informado");
			
			this.book.setTitle(title);
			this.book.setAuthor(author);
			
			return this.bookDAO.create(this.book);
		} catch (Exception e) {
			throw e;
		}
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
