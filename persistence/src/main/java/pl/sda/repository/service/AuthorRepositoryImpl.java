package pl.sda.repository.service;

import model.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.sda.configuration.HibernateJavaConfig;
import pl.sda.repository.AuthorRepository;

import java.util.List;

public class AuthorRepositoryImpl implements AuthorRepository {

    private final Session session;

    public AuthorRepositoryImpl() {
        this.session = HibernateJavaConfig.getSession();
    }

    @Override
    public List<Author> findAll() {
        return session.createQuery("from Author", Author.class).list();
    }

    @Override
    public Author getAuthorById(long id) {
        Transaction transaction = session.beginTransaction();
        Author author = session.load(Author.class, id);
        System.out.println(author);

        transaction.commit();
        return author;
    }

    @Override
    public Author getAuthorByName(String name) {

        Query<Author> query = session.createQuery("FROM Author WHERE last_name = :id", Author.class);
        query.setParameter("id", name);
        System.out.println(query.getSingleResult());
        return query.getSingleResult();
    }

    @Override
    public boolean insertAuthor(Author author) {
        Transaction transaction = session.beginTransaction();
        // save the admin object
        session.save(author);
        // commit transaction
        transaction.commit();
        return true;
    }

    @Override
    public boolean deleteAuthor(long id) {
        return false;
    }
}
