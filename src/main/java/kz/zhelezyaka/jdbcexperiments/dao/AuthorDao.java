package kz.zhelezyaka.jdbcexperiments.dao;

import kz.zhelezyaka.jdbcexperiments.domain.Author;

public interface AuthorDao {
    Author getById(Long id);

    Author findAuthorByName(String firstName, String lastName);

    Author saveNewAuthor(Author author);

    Author updateAuthor(Author saved);

    void deleteAuthorById(Long id);
}
