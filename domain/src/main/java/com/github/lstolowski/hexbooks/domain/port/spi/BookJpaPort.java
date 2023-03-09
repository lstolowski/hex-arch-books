package com.github.lstolowski.hexbooks.domain.port.spi;

import com.github.lstolowski.hexbooks.domain.model.book.Book;

import java.util.List;

/**
 * Secondary type port
 * Database JPA operations
 */
public interface BookJpaPort {
  List<Book> findByIsbn(String isbn);
  List<Book> findAll();
  Book save(Book book);
}
