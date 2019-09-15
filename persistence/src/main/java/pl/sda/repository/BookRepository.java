package pl.sda.repository;

import model.Book;

import java.util.List;

public interface BookRepository {

     List<Book> findAll();

     Book getBookById(long id);

     Book getBookByTitle(String name);

     void insertBook(Book book);

     boolean deleteBook(long id);

}
