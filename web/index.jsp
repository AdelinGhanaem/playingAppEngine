<%@ page import="Comments.Comment" %>
<%@ page import="Comments.CommentsContainerFactory" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: clouway
  Date: 5/29/12
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
    String useNickname = null;
    if (user != null) {
        useNickname = user.getNickname();
%>


<h2>Hello <%=useNickname%>

</h2>

<p> This is my first app engine application.Enjoy writing comments</p>
<%
} else {
%> <p>Hello!
    <a href="<%= userService.createLoginURL(request.getRequestURI()) %>">Sign in</a>
    to include your name with greetings you post.</p>
<%
    }
%>
<div>
    <table>
        <tr>
            <td>Nickname:</td>
            <td>Comment:</td>
        </tr>
        <%
            List<Comment> comments = CommentsContainerFactory.getCommentsContainer().getComments();
            for (Comment comment : comments) {
        %>
        <tr>
            <td><%=comment.getComment()%>
            </td>
            <td><%=comment.getUsername()%>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>

<form action="/sign" method="post">
    <div><label>Comment:</label></div>
    <div>

        <label>
            <textarea name="content" rows="3" cols="60"></textarea>
        </label></div>
    <div><input type="submit" value="Post Greeting"/></div>
    <input type="hidden" name="useNickname" value="<%= useNickname %>"/>
</form>
</body>
</html>