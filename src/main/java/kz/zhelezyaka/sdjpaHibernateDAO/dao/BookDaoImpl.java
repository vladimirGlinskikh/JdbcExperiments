package kz.zhelezyaka.sdjpaHibernateDAO.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import kz.zhelezyaka.sdjpaHibernateDAO.domain.Book;
import org.springframework.stereotype.Component;

@Component
public class BookDaoImpl implements BookDao {
    private final EntityManagerFactory entityManagerFactory;

    public BookDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Book getById(Long id) {
        EntityManager entityManager = getEntityManager();
        Book book = getEntityManager().find(Book.class, id);
        entityManager.close();
        return book;
    }

    @Override
    public Book findBookByTitle(String title) {
        EntityManager entityManager = getEntityManager();
        TypedQuery<Book> query = entityManager
                .createQuery("SELECT b FROM Book b WHERE b.title = :title", Book.class);
        query.setParameter("title", title);
        Book book = query.getSingleResult();
        entityManager.close();
        return book;
    }

    @Override
    public Book saveNewBook(Book book) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
        return book;
    }

    @Override
    public Book updateBook(Book book) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(book);
        entityManager.flush();
        entityManager.clear();
        Book savedBook = entityManager.find(Book.class, book.getId());
        entityManager.getTransaction().commit();
        entityManager.close();
        return savedBook;
    }

    @Override
    public void deleteBookById(Long id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Book book = entityManager.find(Book.class, id);
        entityManager.remove(book);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
