package com.github.lstolowski.hexbooks.domain.port.api;

import com.github.lstolowski.hexbooks.domain.model.book.Book;

import java.util.List;

/**
 * Primary port
 * Exposing the domain outside in the book context
 */
public interface BookServicePort {

  List<Book> getAllBooks();

  Book addBook(Book book);

}
