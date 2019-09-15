package pl.sda.servlet;

import model.Book;
import pl.sda.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/BookAddServlet")
public class BookAddServlet extends HttpServlet {

    private final BookService bookService;

    public BookAddServlet() {
        this.bookService = new BookService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String isbn = request.getParameter("isbn");
        String category = request.getParameter("category");
        String releaseDate = request.getParameter("releaseDate");
        int pages = Integer.parseInt(request.getParameter("pages"));
        String summary = request.getParameter("summary");

        Book book = createBook(title, isbn, category, releaseDate, pages, summary);
        bookService.addBook(book);

        response.sendRedirect("/BooksServlet");
    }

    private Book createBook(String title, String isbn, String category, String releaseDate, int pages, String summary) {
        Book book = new Book();
//            book.setAuthor(new Author());
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setCategory(category);
        book.setReleaseDate(LocalDate.parse(releaseDate));
        book.setPages(pages);
        book.setSummary(summary);
        return book;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("addBook.jsp");
    }
}
