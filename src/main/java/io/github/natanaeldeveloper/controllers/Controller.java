package io.github.natanaeldeveloper.controllers;

import io.github.natanaeldeveloper.utils.JPAConnection;

public class Controller {
	
	public void exit() {
		JPAConnection.getEntityManager().clear();
	}
}
