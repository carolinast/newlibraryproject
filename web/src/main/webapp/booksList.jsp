<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" type="text/css"
          rel="stylesheet">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
</head>
<body>
<form action="/BooksServlet" method="post">
    <table class="table table-dark">
        <tr>
            <th>
                <a href="http://localhost:8095/index.jsp">Back to Main Menu</a>
            </th>
        </tr>
        <tr>
            <th>

            </th>
            <td>
                <button type="submit" class="btn btn-primary" name="action" value="add">Add</button>
            </td>
            <td>
                <button type="submit" class="btn btn-primary" name="action" value="edit">Edit</button>
            </td>
            <td>
                <button type="submit" class="btn btn-primary" name="action" value="delete">Delete</button>
            </td>
            <td>
                <button type="submit" class="btn btn-primary" name="action" value="details">Details</button>
            </td>
        </tr>

    </table>

    <table class="table table-dark">

        <thead>
        <tr>
            <th scope="col">Id</th>

            <th scope="col">Title</th>
            <th scope="col">Author</th>
            <th scope="col">ISBN</th>
            <th scope="col">Category</th>
            <th scope="col">Release date</th>
            <th scope="col">Borrower</th>

            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <div class="custom-control custom-radio">
            <c:forEach var="b" items="${requestScope.bookList}" varStatus="loop">
                <tr>
                    <th scope="row">${b.idBook}</th>

                    <td>${b.title}</td>
                    <td>${b.author.firstName} ${b.author.lastName}</td>
                    <td>${b.isbn}</td>
                    <td>${b.category}</td>
                    <td>${b.releaseDate}</td>
                    <td>${b.borrowerName}</td>

                    <td>
                        <div class="action-group-checkbox">
                            <input type="radio" name="bookId" value="${b.idBook}" checked>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </div>

        </tbody>
    </table>
</form>

</body>
</html>
