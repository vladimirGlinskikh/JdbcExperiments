package kz.zhelezyaka.sdjpaHibernateDAO.repositories;

import kz.zhelezyaka.sdjpaHibernateDAO.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}