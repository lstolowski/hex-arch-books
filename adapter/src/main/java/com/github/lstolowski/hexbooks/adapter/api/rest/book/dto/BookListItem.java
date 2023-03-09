package com.github.lstolowski.hexbooks.adapter.api.rest.book.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BookListItem {

  private String title;
  private String authors;

}
