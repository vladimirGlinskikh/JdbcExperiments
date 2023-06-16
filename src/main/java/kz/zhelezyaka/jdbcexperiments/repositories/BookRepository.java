package kz.zhelezyaka.jdbcexperiments.repositories;

import kz.zhelezyaka.jdbcexperiments.domain.Author;
import kz.zhelezyaka.jdbcexperiments.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
