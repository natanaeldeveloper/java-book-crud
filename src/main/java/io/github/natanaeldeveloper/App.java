package io.github.natanaeldeveloper;

import io.github.natanaeldeveloper.controllers.BookController;
import io.github.natanaeldeveloper.models.Book;

/**
 * Hello world!
 *
 */
public class App 
{		
    public static void main( String[] args ) {
    	BookController bookController = new BookController();        
    	Book book = bookController.createBook("Meu Segundo Livro", "Natanael Oliveira");
    	System.out.println(book != null ? book.toString(): "Nenhum registro encontrado!");
    }
}
