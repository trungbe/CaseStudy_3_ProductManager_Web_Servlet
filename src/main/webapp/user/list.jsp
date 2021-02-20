<%--
  Created by IntelliJ IDEA.
  User: Dat Bong
  Date: 2/20/2021
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<h1>User List</h1>
<table style="border: black solid">
    <tr>
        <td>Usernam</td>
        <td>Password</td>
        <td>Fullname</td>
        <td>Birthday</td>
        <td>Address</td>
    </tr>
    <tr>
        <c:forEach items="${list}" var="user">
        <td>${user.getUsername()}</td>
        <td>${user.getPassword()}</td>
        <td>${user.getFullname()}</td>
        <td>${user.getBirthday()}</td>
        <td>${user.getAddress()}</td>
    <tr/>
    </c:forEach>
</table>
</body>
</html>
