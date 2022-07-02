package io.github.natanaeldeveloper.dao;

import java.util.List;

public interface DataAccessObjectGeneric <T, ID> {
	
	public T create(T obj) throws Exception;
	
	public T get(ID id) throws Exception;
	
	public List<T> getAll() throws Exception;

	public T update(T obj, ID id) throws Exception;
	
	public Boolean remove(ID id) throws Exception;
}
