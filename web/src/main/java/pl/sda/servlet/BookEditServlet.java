package pl.sda.servlet;

import model.Book;
import pl.sda.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BookEditServlet")
public class BookEditServlet extends HttpServlet {

    private final BookService bookService;

    public BookEditServlet() {
        this.bookService = new BookService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long bookId = Long.valueOf(request.getParameter("bookId"));
        Book book = bookService.findBook(bookId);
        request.setAttribute("book", book);
        request.getRequestDispatcher("editBook.jsp").forward(request, response);
    }

}

