<%@ page import="datastore.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="datastore.entites.Book" %>
<%--
  Created by IntelliJ IDEA.
  User: clouway
  Date: 6/1/12
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>asdasdsada</title>
</head>
<body>
<%
    List<Book> books = (List<Book>) request.getAttribute("books");
%>
<table>
    <tr>
        <td>Book name</td>

        <td>Book id:</td>
    </tr>

    <%

        for (Book book : books) {
    %>
    <tr>
        <td><%=book.geName()%>
        </td>
        <td><%=book.getId()%>
        </td>
    </tr>
    <%
        }
    %>


</table>

<form method="GET" action="/emploiesstore">

    <label>
        first name:
        <input type="text" name="firstname">
    </label>

    <input type="submit" value="add employee"/>
</form>

</body>
</html>