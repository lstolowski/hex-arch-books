package com.github.lstolowski.hexbooks.domain.model.book.exception;

public class BookNotValidException extends RuntimeException {
  public BookNotValidException(String s) {
    super(s);
  }
}
