package kz.zhelezyaka.sdjpaJdbcTemplate;

import kz.zhelezyaka.jdbcexperiments.dao.BookDao;
import kz.zhelezyaka.jdbcexperiments.dao.BookDaoImpl;
import kz.zhelezyaka.sdjpaJdbcTemplate.domain.Author;
import kz.zhelezyaka.sdjpaJdbcTemplate.dao.AuthorDao;
import kz.zhelezyaka.sdjpaJdbcTemplate.dao.AuthorDaoImpl;
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
@Import({AuthorDaoImpl.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AuthorDaoIntegrationTest {

    @Autowired
    AuthorDao authorDao;

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
