package com.github.lstolowski.hexbooks.adapter.spi.jpa.book;

import com.github.lstolowski.hexbooks.adapter.spi.jpa.book.entity.BookEntity;
import com.github.lstolowski.hexbooks.adapter.spi.jpa.book.mapper.BookEntityMapper;
import com.github.lstolowski.hexbooks.adapter.spi.jpa.book.repository.BookJpaRepository;
import com.github.lstolowski.hexbooks.domain.model.book.Book;
import com.github.lstolowski.hexbooks.domain.model.book.validation.BookValidator;
import com.github.lstolowski.hexbooks.domain.port.spi.BookJpaPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github.lstolowski.hexbooks.adapter.spi.jpa.book.mapper.BookEntityMapper.toBook;
import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class BookJpaAdapter implements BookJpaPort {

  private BookJpaRepository bookJpaRepository;

  @Override
  public List<Book> findByIsbn(String isbn) {

    return this.bookJpaRepository.findByIsbn(isbn).stream()
        .map(BookEntityMapper::toBook)
        .collect(toList());
  }

  @Override
  public List<Book> findAll() {
    return this.bookJpaRepository.findAll().stream()
        .map(BookEntityMapper::toBook)
        .collect(toList());
  }

  @Override
  public Book save(Book book) {
    BookValidator validator = new BookValidator();
    validator.validate(book);

    BookEntity entity = BookEntityMapper.toEntity(book);

    return toBook(this.bookJpaRepository.save(entity));

  }

}
