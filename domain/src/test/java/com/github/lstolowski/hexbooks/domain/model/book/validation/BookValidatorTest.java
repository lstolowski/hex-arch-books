package com.github.lstolowski.hexbooks.domain.model.book.validation;

import com.github.lstolowski.hexbooks.domain.model.book.Book;
import com.github.lstolowski.hexbooks.domain.model.book.exception.BookNotValidException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookValidatorTest {

  /*
    Example of trivial business logic test which belongs to domain module
   */

  @Test
  public void shouldNotAcceptEmptyIsbnInTheBook() {
    // given
    Book book = Book.builder().isbn("").build();
    var validator = new BookValidator();

    // when
    BookNotValidException thrown = assertThrows(BookNotValidException.class, () -> {
      validator.validate(book);
    });

    // then
    assertEquals("ISBN cannot be empty for any book", thrown.getMessage());

  }
}