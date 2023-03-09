package com.github.lstolowski.hexbooks.adapter.api.rest.book;

import com.github.lstolowski.hexbooks.adapter.api.rest.book.dto.BookListItem;
import com.github.lstolowski.hexbooks.adapter.api.rest.book.dto.BookSimpleAdd;
import com.github.lstolowski.hexbooks.domain.model.author.Author;
import com.github.lstolowski.hexbooks.domain.model.book.Book;
import com.github.lstolowski.hexbooks.domain.port.api.BookServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class BookService {

  private BookServicePort bookServicePort;

  @Autowired
  public BookService(BookServicePort bookServicePort) {
    this.bookServicePort = bookServicePort;
  }

  public List<BookListItem> findAllListItems() {
    return bookServicePort.getAllBooks().stream()
        .map(b -> BookListItem.builder()
                    .title(b.getName())
                    .authors(b.getAuthors().stream()
                                  .map(Author::getLastName)
                                  .collect(Collectors.joining(", "))
                    )
                  .build())
        .collect(toList());
  }

  public Book addSimpleBook(BookSimpleAdd book) {

    var saved = bookServicePort.addBook(Book.builder()
            .isbn(book.getIsbn())
            .name(book.getTitle())
            .authors(List.of(Author.builder()
                  .lastName(book.getAuthorLastName())
                  .firstName(book.getAuthorFirstName())
                .build())
            )
        .build());

    return saved;
  }

}
