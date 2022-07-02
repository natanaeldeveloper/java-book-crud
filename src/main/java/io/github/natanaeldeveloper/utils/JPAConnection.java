package io.github.natanaeldeveloper.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAConnection {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Library-mysql");
	private static EntityManager entityManager;
	
	public static EntityManager getEntityManager() {
		if(entityManager == null) {
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}
}
