package pl.sda.repository;

import model.Author;

import java.util.List;

public interface AuthorRepository {

     List<Author> findAll();

     Author getAuthorById(long id);

     Author getAuthorByName(String name);

     boolean insertAuthor(Author author);

     boolean deleteAuthor(long id);
}
