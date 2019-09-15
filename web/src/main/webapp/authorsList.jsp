<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" type="text/css"
          rel="stylesheet">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
</head>
<body>

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
            <a href="http://localhost:8095/addAuthor.jsp">Add</a>
        </td>
        <td>
            <a href="http://localhost:8095/editAuthor.jsp">Edit</a>
        </td>
        <td>
            <a href="http://localhost:8095/delete.jsp">Delete</a>
        </td>
        <td>
            <a href="http://localhost:8095/details.jsp">Details</a>
        </td>
    </tr>

</table>

<table class="table table-dark">

    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">First name</th>
        <th scope="col">Last name</th>
        <th scope="col">Birth place</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
     <c:forEach var="b" items="${requestScope.authorList}" varStatus="loop" >
        <tr>
            <th scope="row">${b.idAuthor}</th>
            <td>${b.firstName}</td>
            <td>${b.lastName}</td>
            <td>${b.birthPlace}</td>
            <td>
                <div class="action-group-checkbox">
                        <input type="checkbox">
                </div>
            </td>
        </tr>
     </c:forEach>

    </tbody>
</table>
</body>
</html>
