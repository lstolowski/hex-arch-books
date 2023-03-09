package com.github.lstolowski.hexbooks.domain.port.spi;

import com.github.lstolowski.hexbooks.domain.model.book.GoodreadsRating;

import java.math.BigDecimal;
import java.util.List;

/**
 * Secondary type port
 * Gets information/comments/ratings from external book service Goodreads.com
 */
public interface BookGoodreadsPort {

  BigDecimal fetchAvgRatingValue(String isbn);
  List<GoodreadsRating> fetchRatings(String isbn, Integer limit);

}
