package com.github.lstolowski.hexbooks.adapter.spi.jpa.book.repository;

import com.github.lstolowski.hexbooks.adapter.spi.jpa.book.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookJpaRepository extends CrudRepository<BookEntity, Long>{

  List<BookEntity> findByIsbn(String isbn);
  List<BookEntity> findAll();
}
