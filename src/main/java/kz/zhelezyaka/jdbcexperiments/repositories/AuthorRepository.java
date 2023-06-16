package kz.zhelezyaka.jdbcexperiments.repositories;

import kz.zhelezyaka.jdbcexperiments.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
