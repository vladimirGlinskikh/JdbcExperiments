package kz.zhelezyaka.sdjpaJdbcTemplate;

import kz.zhelezyaka.sdjpaJdbcTemplate.dao.BookDao;
import kz.zhelezyaka.sdjpaJdbcTemplate.dao.BookDaoImpl;
import kz.zhelezyaka.sdjpaJdbcTemplate.domain.Author;
import kz.zhelezyaka.sdjpaJdbcTemplate.dao.AuthorDao;
import kz.zhelezyaka.sdjpaJdbcTemplate.dao.AuthorDaoImpl;
import kz.zhelezyaka.sdjpaJdbcTemplate.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ActiveProfiles("local")
@DataJpaTest
@Import({AuthorDaoImpl.class, BookDaoImpl.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AuthorDaoIntegrationTest {

    @Autowired
    AuthorDao authorDao;

    @Autowired
    BookDao bookDao;

    @Test
    void testDeleteBook() {
        Book book = new Book();
        book.setIsbn("1234");
        book.setPublisher("Ozon");
        book.setTitle("my book");
        Book saved = bookDao.saveNewBook(book);

        bookDao.deleteBookById(saved.getId());

        assertThrows(EmptyResultDataAccessException.class, () -> {
            bookDao.getById(saved.getId());
        });
    }

    @Test
    void updateBookTest() {
        Book book = new Book();
        book.setIsbn("1234");
        book.setPublisher("Ozon");
        book.setTitle("my book");
        book.setAuthorId(1L);

        Book saved = bookDao.saveNewBook(book);

        saved.setTitle("New Book");
        bookDao.updateBook(saved);

        Book fetched = bookDao.getById(saved.getId());

        assertThat(fetched.getTitle()).isEqualTo("New Book");
    }

    @Test
    void testSaveBook() {
        Book book = new Book();
        book.setIsbn("1234");
        book.setPublisher("Self");
        book.setTitle("my book");
        book.setAuthorId(1L);

        Book saved = bookDao.saveNewBook(book);

        assertThat(saved).isNotNull();
    }

    @Test
    void testGetBookByName() {
        Book book = bookDao.findBookByTitle("Clean Code");

        assertThat(book).isNotNull();
    }

    @Test
    void testGetBook() {
        Book book = bookDao.getById(3L);

        assertThat(book.getId()).isNotNull();
    }

    @Test
    void testInsertAuthor() {
        Author author = new Author();
        author.setFirstName("Vladimir");
        author.setLastName("GL");

        Author saved = authorDao.saveNewAuthor(author);
        System.out.println("New Id is: " + saved.getId());

        assertThat(saved).isNotNull();
    }

    @Test
    void testDeleteAuthor() {
        Author author = new Author();
        author.setFirstName("Vladimir");
        author.setLastName("G");

        Author saved = authorDao.saveNewAuthor(author);
        authorDao.deleteAuthorById(saved.getId());

        assertThrows(EmptyResultDataAccessException.class, () -> {
            authorDao.getById(saved.getId());
        });
    }

    @Test
    void testUpdateAuthor() {
        Author author = new Author();
        author.setFirstName("Vladimir");
        author.setLastName("GLINZ");

        Author saved = authorDao.saveNewAuthor(author);

        saved.setLastName("Glinskikh");
        Author updated = authorDao.updateAuthor(saved);

        assertThat(updated.getLastName()).isEqualTo("Glinskikh");
    }

    @Test
    void testSaveAuthor() {
        Author author = new Author();
        author.setFirstName("Vladimir");
        author.setLastName("Glinskikh");
        Author saved = authorDao.saveNewAuthor(author);

        assertThat(saved).isNotNull();
    }

    @Test
    void testGetAuthorByName() {
        Author author = authorDao.findAuthorByName("Craig", "Walls");
        assertThat(author).isNotNull();
    }

    @Test
    void testGetAuthor() {
        Author author = authorDao.getById(1L);
        assertThat(author).isNotNull();
    }
}
