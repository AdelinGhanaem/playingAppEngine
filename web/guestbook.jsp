<%@ page import="com.google.appengine.api.datastore.DatastoreService" %>
<%@ page import="com.google.appengine.api.datastore.DatastoreServiceFactory" %>
<%@ page import="com.google.appengine.api.datastore.Entity" %>
<%@ page import="com.google.appengine.api.datastore.FetchOptions" %>
<%@ page import="com.google.appengine.api.datastore.Key" %>
<%@ page import="com.google.appengine.api.datastore.KeyFactory" %>
<%@ page import="com.google.appengine.api.datastore.Query" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="java.util.List" %>


<%--
  Created by IntelliJ IDEA.
  User: clouway
  Date: 5/29/12
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title></title>
</head>
<body>


<%

    UserService service = UserServiceFactory.getUserService();

    User user = service.getCurrentUser();

    if (user != null) {
%><P>Hello, <%=user.getNickname()%>     ! you can
    <a href="<%= service.createLogoutURL(request.getRequestURI()) %>">sign out</a>.)</p>
<%
} else {
%> <p>Hello!
    <a href="<%= service.createLoginURL(request.getRequestURI()) %>">Sign in</a>
    to include your name with greetings you post.</p>
<%
    }


%>



</body>
</html>