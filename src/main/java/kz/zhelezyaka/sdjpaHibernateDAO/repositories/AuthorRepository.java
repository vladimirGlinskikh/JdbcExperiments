package kz.zhelezyaka.sdjpaHibernateDAO.repositories;

import kz.zhelezyaka.sdjpaHibernateDAO.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}