package com.github.lstolowski.hexbooks.adapter.spi.jpa.author.mapper;

import com.github.lstolowski.hexbooks.adapter.spi.jpa.author.entity.AuthorEntity;
import com.github.lstolowski.hexbooks.domain.model.author.Author;

public class AuthorEntityMapper {

  /*
    Maybe we could use other mapping solutions instead do it by hand.
    eg: mapstruct, dozer etc
    But it was quicker in this simple case than configuring another framework.
  */

  public static Author toAuthor(AuthorEntity a) {
    return Author
        .builder()
        .firstName(a.getFirstName())
        .lastName(a.getLastName())
        .build();
  }

  public static AuthorEntity toEntity(Author a) {
    var entity = new AuthorEntity();
    entity.setFirstName(a.getFirstName());
    entity.setLastName(a.getLastName());
    entity.setBio("To be done");
    return entity;
  }
}
