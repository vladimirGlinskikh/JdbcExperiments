package kz.zhelezyaka.sdjpaJdbcTemplate.dao;

import kz.zhelezyaka.sdjpaJdbcTemplate.domain.Author;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

@Component
public class AuthorDaoImpl implements AuthorDao {

    @Override
    public Author getById(Long id) {
        return null;
    }

    @Override
    public Author findAuthorByName(String firstName, String lastName) {
        return null;
    }

    @Override
    public Author saveNewAuthor(Author author) {
        return null;
    }

    @Override
    public Author updateAuthor(Author saved) {
        return null;
    }

    @Override
    public void deleteAuthorById(Long id) {

    }

    private RowMapper<Author> getRowMapper() {
        return new AuthorMapper();
    }
}
