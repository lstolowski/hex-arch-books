package hexbooks.adapter.spi.jpa.book;

import com.github.lstolowski.hexbooks.adapter.spi.jpa.book.BookJpaAdapter;
import com.github.lstolowski.hexbooks.adapter.spi.jpa.book.entity.BookEntity;
import com.github.lstolowski.hexbooks.adapter.spi.jpa.book.repository.BookJpaRepository;
import com.github.lstolowski.hexbooks.domain.model.book.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookJpaAdapterTest {

  @Mock
  private BookJpaRepository bookJpaRepository;

  @InjectMocks
  private BookJpaAdapter bookJpaAdapter;


  @Test
  public void shouldFindOneBookByIsbnAndMapCorrectlyToDomainModel() {
    // given
    var isbn = "123456";
    var bookEntity = createBookEntity();
    when(this.bookJpaRepository.findByIsbn(eq(isbn))).thenReturn(
        List.of(bookEntity)
    );

    // when
    List<Book> result = this.bookJpaAdapter.findByIsbn(isbn);

    // then
    assertNotNull(result, "should return empty collection not a null");
    assertEquals(1, result.size(), "should return only one bookEntity");
    var resultBook = result.get(0);
    assertEquals(isbn, resultBook.getIsbn() );
    assertEquals("Test Book of Wonders", resultBook.getName());
    // etc
  }

  @Test
  public void shouldNotFindBookByIsbnAndReturnEmptyCollection() {
    // given
    var isbn = "123456";
    when(this.bookJpaRepository.findByIsbn(eq(isbn))).thenReturn(emptyList());

    // when
    List<Book> result = this.bookJpaAdapter.findByIsbn(isbn);

    // then
    assertNotNull(result, "should return empty collection not a null");
    assertTrue(result.size() == 0, "should return only one bookEntity");
  }


  private BookEntity createBookEntity() {
    var book = new BookEntity();
    book.setId(1L);
    book.setIsbn("123456");
    book.setName("Test Book of Wonders");
    book.setAuthors(emptyList());
    return book;
  }
}