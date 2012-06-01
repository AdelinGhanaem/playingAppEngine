<%@ page import="comments.LuckyEmails" %>
<%@ page import="java.io.PrintWriter" %>
<%--
  Created by IntelliJ IDEA.
  User: clouway
  Date: 5/31/12
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%

    PrintWriter printWriter = response.getWriter();
    printWriter.println("Lucky emails .... ");
    printWriter.print("</br>");
    for (String email : LuckyEmails.getEmails()) {
        printWriter.println("email: " + email);
        printWriter.print("</br>");
    }


%>

</body>
</html>