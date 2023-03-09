package com.github.lstolowski.hexbooks.adapter.api.rest.book.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookSimpleAdd {

  private String title;
  private String isbn;
  private String authorFirstName;
  private String authorLastName;

}
