package pl.sda.repository.service;

import model.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.configuration.HibernateJavaConfig;
import pl.sda.repository.BookRepository;

import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    private final Session session;

    public BookRepositoryImpl() {
        this.session = HibernateJavaConfig.getSession();
    }

    @Override
    public List<Book> findAll() {
        return session.createQuery("from Book", Book.class).list();
    }

    @Override
    public Book getBookById(long id) {
        return session.createQuery("from Book b WHERE b.idBook = :id", Book.class)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public Book getBookByTitle(String name) {
        return null;
    }

    @Override
    public void insertBook(Book book) {
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.persist(book);
        transaction.commit();
    }

    @Override
    public boolean deleteBook(long id) {
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Book book = session.find(Book.class, id);
        session.remove(book);
        transaction.commit();
        return false;
    }
}
