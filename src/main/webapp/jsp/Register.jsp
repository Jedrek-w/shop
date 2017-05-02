<%--
  Created by IntelliJ IDEA.
  User: Jedrek
  Date: 2017/4/30
  Time: 13:09
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
    <form action="<%= path%>/hehe" method="post">
        名字：<input type="text" name="name">
        账号：<input type="text" name="account">
        密码：<input type="text" name="password">
        密码2：<input type="text" name="repassword">
        电话：<input type="text" name="phone">
        地址：<input type="text" name="address">
        <input type="submit" name="sub">
    </form>
</body>
</html>
