package kz.zhelezyaka.sdjpaHibernateDAO.dao;

import kz.zhelezyaka.sdjpaHibernateDAO.domain.Author;

import java.util.List;

public interface AuthorDao {
    List<Author> listAuthorByLastNameLike(String lastName);

    Author getById(Long id);

    Author findAuthorByName(String firstName, String lastName);

    Author saveNewAuthor(Author author);

    Author updateAuthor(Author author);

    void deleteAuthorById(Long id);
}