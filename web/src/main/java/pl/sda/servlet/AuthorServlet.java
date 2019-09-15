package pl.sda.servlet;

import model.Author;
import pl.sda.service.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/AuthorServlet")
public class AuthorServlet extends HttpServlet {

    private final AuthorService authorService;

    public AuthorServlet() {
        this.authorService = new AuthorService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Author> authors = authorService.authorsList();
        request.setAttribute("authorList",authors);
        request.getRequestDispatcher("authorsList.jsp").forward(request,response);

    }
}
