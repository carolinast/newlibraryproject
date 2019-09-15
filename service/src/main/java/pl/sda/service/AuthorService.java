package pl.sda.service;

import model.Author;
import model.Book;
import pl.sda.repository.AuthorRepository;
import pl.sda.repository.service.AuthorRepositoryImpl;

import java.util.List;

public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService() {
        this.authorRepository = new AuthorRepositoryImpl();
    }

    public List<Author> authorsList(){
        return authorRepository.findAll();
    }

}
