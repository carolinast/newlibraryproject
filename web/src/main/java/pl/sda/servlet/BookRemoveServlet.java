package pl.sda.servlet;

import pl.sda.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BookRemoveServlet")
public class BookRemoveServlet extends HttpServlet {

    private final BookService bookService;

    public BookRemoveServlet() {
        this.bookService = new BookService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        bookService.deleteBook(Long.valueOf(request.getParameter("bookId")));
        response.sendRedirect("/BooksServlet");
    }
}
