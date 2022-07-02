package io.github.natanaeldeveloper.dao;

import java.util.List;

import javax.persistence.EntityManager;

import io.github.natanaeldeveloper.models.Book;

public class BookDAO implements DataAccessObjectGeneric<Book, Long>{
	
	private EntityManager em;
	
	public BookDAO(EntityManager entityManager) {
		this.em = entityManager;
	}

	@Override
	public Book create(Book obj) throws Exception {
		this.em.getTransaction().begin();
		this.em.persist(obj);
		this.em.getTransaction().commit();
		return obj;
	}

	@Override
	public Book get(Long id) throws Exception {
		return this.em.find(Book.class, id);
	}

	@Override
	public List<Book> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book update(Book obj, Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean remove(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
