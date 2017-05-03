<%--
  Created by IntelliJ IDEA.
  User: Jedrek
  Date: 2017/5/3
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
%>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<form action="<%= path%>/haha" method="post">
    账号：<input type="text" name="account">
    密码：<input type="text" name="password">
    <input type="submit" name="sub">
</form>
</body>
</html>
