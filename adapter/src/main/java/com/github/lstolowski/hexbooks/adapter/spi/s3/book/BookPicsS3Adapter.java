package com.github.lstolowski.hexbooks.adapter.spi.s3.book;

import com.github.lstolowski.hexbooks.domain.model.book.BookPicture;
import com.github.lstolowski.hexbooks.domain.port.spi.BookPicsS3Port;

public class BookPicsS3Adapter implements BookPicsS3Port {

  @Override
  public BookPicture fetchPictureByIsbn(String isbn) {

    // TODO implement downloading the picture from AWS S3 bucket
    // and map it into a BookPicture object
    return null;
  }
}
