package kz.zhelezyaka.jdbcexperiments.dao;

import kz.zhelezyaka.jdbcexperiments.domain.Author;

public interface AuthorDao {
    Author getById(Long id);
}
