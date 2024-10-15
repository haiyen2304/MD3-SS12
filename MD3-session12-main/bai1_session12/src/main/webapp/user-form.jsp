<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/28/2024
  Time: 11:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${user==null ? "Create new category" : "Update Category"}</h1>
<form action="LoadUser" method="post">
    <input type="hidden" name="action" value="${user == null ? 'save' : 'update'}">
    <c:if test="${user != null}">
    <input type="hidden" name="id" value="${user.id}">
    </c:if>
    <label for="username">username: </label>
    <input type="text" name="username" id="username" value="${user != null ? user.username : ''}" required>
    <label for="password">password: </label>
    <input type="text" name="password" id="password" value="${user != null ? user.password : ''}" required>
    <label for="fullName">fullName: </label>
    <input type="text" name="fullName" id="fullName" value="${user != null ? user.fullName : ''}" required>
    <label for="address">address: </label>
    <input type="text" name="address" id="address" value="${user != null ? user.address : ''}" required>
    <label for="email">email: </label>
    <input type="text" name="email" id="email" value="${user != null ? user.email : ''}" required>
    <label for="phone">phone: </label>
    <input type="text" name="phone" id="phone" value="${user != null ? user.phone : ''}" required>
    <button type="submit">Save</button>
</body>
</html>
