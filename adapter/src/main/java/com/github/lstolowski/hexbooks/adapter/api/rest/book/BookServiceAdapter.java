package com.github.lstolowski.hexbooks.adapter.api.rest.book;

import com.github.lstolowski.hexbooks.domain.model.book.Book;
import com.github.lstolowski.hexbooks.domain.port.api.BookServicePort;
import com.github.lstolowski.hexbooks.domain.port.spi.BookJpaPort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for the application to serve Books for the primary port+adapter (rest endpoint of the app)
 */
@Service
public class BookServiceAdapter implements BookServicePort {

  private BookJpaPort bookJpaPort;

  public BookServiceAdapter(BookJpaPort bookJpaPort) {
    this.bookJpaPort = bookJpaPort;
  }

  @Override
  public List<Book> getAllBooks() {
    return this.bookJpaPort.findAll();
  }

  @Override
  public Book addBook(Book book) {
    return bookJpaPort.save(book);
  }
}
