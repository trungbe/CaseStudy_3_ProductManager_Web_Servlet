<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>Username</td>
        <td>Password</td>
        <td>Fullname</td>
        <td>Birthday</td>
        <td>Address</td>
    </tr>
    <c:forEach items="${userList}" var="user">
        <tr>
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
