<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 14.04.2019
  Time: 09:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" type="text/css"
          rel="stylesheet">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <title>Add Book</title>
</head>
<body style="background-color: darkgrey">
<div class="container mt-5">
    <form name="form" action="BookAddServlet" method="post" onsubmit="return validate()">
        <table class="table table-dark" align="center">
            <tr>
                <td>Title</td>
                <td><input type="text" class="form-control" name="title"/></td>
            </tr>
            <%--<tr>--%>
                <%--<td>Author</td>--%>
                <%--<td><input type="text" class="form-control" name="author"/></td>--%>
            <%--</tr>--%>
            <tr>
                <td>ISBN</td>
                <td><input type="text" class="form-control" name="isbn" maxlength="13" minlength="13"/></td>
            </tr>
            <tr>
                <td>Category</td>
                <td>
                    <select type="text" class="form-control" name="category">
                        <option>...</option>
                        <option>HORROR</option>
                        <option>FANTASY</option>
                        <option>HISTORY</option>
                        <option>BIOGRAPHY</option>
                        <option>DRAMA</option>
                        <option>ROMANCE</option>
                        <option>COMEDY</option>
                        <option>OTHER</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Release Date</td>
                <td><input type="date" class="form-control" name="releaseDate"/></td>
            </tr>
            <tr>
                <td>Number of Pages</td>
                <td><input type="number" class="form-control" name="pages"/></td>
            </tr>
            <tr>
                <td>Summary</td>
                <td><textarea type="text" maxlength="350" class="form-control"></textarea></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button type="submit" class="btn btn-primary">Add</button>

                </td>
            </tr>
        </table>
    </form>
   <center>
       <a href="/BooksServlet"><button type="reset" class="btn btn-primary">Cancel</button></a>
   </center>
</div>
</body>
</html>
