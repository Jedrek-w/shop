<%--
  Created by IntelliJ IDEA.
  User: Jedrek
  Date: 2017/5/2
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String s = (String)request.getAttribute("info");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>this is a message <%= s %></h1>
</body>
</html>
