package com.github.lstolowski.hexbooks.domain.model.book;

import com.github.lstolowski.hexbooks.domain.model.author.Author;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Book {
  private String name;
  private String isbn;
  private List<Author> authors;
}
