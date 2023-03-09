package com.github.lstolowski.hexbooks.adapter.spi.jpa.book.entity;

import com.github.lstolowski.hexbooks.adapter.spi.jpa.author.entity.AuthorEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
@NoArgsConstructor
@Data
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "books_authors",
        joinColumns = { @JoinColumn(name = "book_id") },
        inverseJoinColumns = { @JoinColumn(name = "author_id") }
    )
    private List<AuthorEntity> authors;
    private String isbn;


}
