package com.github.lstolowski.hexbooks.adapter.spi.jpa.book.mapper;

import com.github.lstolowski.hexbooks.adapter.spi.jpa.author.mapper.AuthorEntityMapper;
import com.github.lstolowski.hexbooks.adapter.spi.jpa.book.entity.BookEntity;
import com.github.lstolowski.hexbooks.domain.model.book.Book;

import static java.util.stream.Collectors.toList;

public class BookEntityMapper {

  /*
    Maybe we could use other mapping solutions instead do it by hand.
    eg: mapstruct, dozer etc
    But it was quicker in this simple case than configuring another framework.
  */

  public static Book toBook(BookEntity e) {
    return Book
        .builder()
        .name(e.getName())
        .isbn(e.getIsbn())
        .authors(
            e.getAuthors().stream()
                .map(AuthorEntityMapper::toAuthor)
                .collect(toList())
        )
        .build();
  }

  public static BookEntity toEntity(Book b) {
    var entity = new BookEntity();

    entity.setIsbn(b.getIsbn());
    entity.setName(b.getName());
    entity.setAuthors(b.getAuthors().stream()
        .map(AuthorEntityMapper::toEntity)
        .collect(toList()));

    return entity;
  }
}
