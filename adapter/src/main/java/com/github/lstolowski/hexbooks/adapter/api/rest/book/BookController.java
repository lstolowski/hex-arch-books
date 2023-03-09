package com.github.lstolowski.hexbooks.adapter.api.rest.book;

import com.github.lstolowski.hexbooks.adapter.api.rest.book.dto.BookListItem;
import com.github.lstolowski.hexbooks.adapter.api.rest.book.dto.BookSimpleAdd;
import com.github.lstolowski.hexbooks.domain.model.book.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@Slf4j
public class BookController {

  private BookService bookService;

  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/list")
  public List<BookListItem> listBooks() {

    log.debug("listBooks invoked");

    return bookService.findAllListItems();
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED, reason = "OK")
  public Book addBook(@RequestBody BookSimpleAdd simpleBook) {

    return bookService.addSimpleBook(simpleBook);

  }
}
