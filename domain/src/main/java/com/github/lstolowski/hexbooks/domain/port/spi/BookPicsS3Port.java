package com.github.lstolowski.hexbooks.domain.port.spi;

import com.github.lstolowski.hexbooks.domain.model.book.BookPicture;

/**
 * Secondary type port
 * Book pictures operations on S3
 */
public interface BookPicsS3Port {

  BookPicture fetchPictureByIsbn(String isbn);

}
