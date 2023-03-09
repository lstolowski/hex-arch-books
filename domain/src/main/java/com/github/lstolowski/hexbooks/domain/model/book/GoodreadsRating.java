package com.github.lstolowski.hexbooks.domain.model.book;

import lombok.Data;

import java.util.Date;

/**
 * Book comment and rating fetched from Goodreads
 */
@Data
public class GoodreadsRating {
  private Long id;
  private String readerName;
  private Date commentDate;
  private String comment;
  private Integer rate;

}
