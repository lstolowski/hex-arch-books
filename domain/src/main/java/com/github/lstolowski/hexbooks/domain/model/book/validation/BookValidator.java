package com.github.lstolowski.hexbooks.domain.model.book.validation;

import com.github.lstolowski.hexbooks.domain.model.book.Book;
import com.github.lstolowski.hexbooks.domain.model.book.exception.BookNotValidException;
import org.apache.commons.lang3.StringUtils;

public class BookValidator {

  /*
    Here it is a trivial example of a business logic that should belong to the domain module.
    ... I had no idea for a better example

    Normally for such simpl e validation rules we should use javax.validation annotations (@NotNUll, @Min, @Max etc)
   */

  public void validate(Book book) {
    if (StringUtils.isBlank(book.getIsbn())) throw new BookNotValidException("ISBN cannot be empty for any book");
    // some more logic ...
  }
}
