package pl.sda.servlet;

import model.Book;
import pl.sda.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/BooksServlet")
public class BooksServlet extends HttpServlet {

    private final BookService bookService;

    public BooksServlet() {
        this.bookService = new BookService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        String bookId = request.getParameter("bookId");

        switch (action) {
            case "add":
                response.sendRedirect("/BookAddServlet" );
                break;
            case "edit":
                response.sendRedirect("/BookEditServlet?bookId=" + bookId);
                break;
            case "delete":
                response.sendRedirect("/BookRemoveServlet?bookId=" + bookId);
                break;
            case "details":
                response.sendRedirect("/BookDetailsServlet?bookId=" + bookId);
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookService.bookList();
        request.setAttribute("bookList",books);
        request.getRequestDispatcher("booksList.jsp").forward(request,response);
    }
}
