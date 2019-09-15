package pl.sda.service;

import model.Book;
import model.Borrow;
import pl.sda.repository.BookRepository;
import pl.sda.repository.service.BookRepositoryImpl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookService {

    private final BookRepository bookRepository;

    public BookService() {
        this.bookRepository = new BookRepositoryImpl();
    }

    public List<Book> bookList() {

        return bookRepository.findAll()
                .stream().peek(book -> book.setBorrowerName(findBorrowerName(book)))
                .collect(Collectors.toList());
    }

    private String findBorrowerName(Book book) {
        if (book.isBorrowed()) {
            Optional<Borrow> borrow = book.getBorrowList()
                    .stream()
                    .max(Comparator.comparing(Borrow::getIdBorrow));
            if (borrow.isPresent()) {
                return borrow.get().getBorrower().borrowerFullName();
            }
        }
        return "Brak";
    }

    public void addBook(Book book) {
        bookRepository.insertBook(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteBook(id);
    }

    public Book findBook(Long bookId) {
        return bookRepository.getBookById(bookId);
    }
}
