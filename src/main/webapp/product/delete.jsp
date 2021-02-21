<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/21/2021
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>
<h1>Delete  product</h1>
<form method="post"></form>
<a href="/products">List product</a>
<table>
    <tr>
        <td>Name</td>
        <td><input value="${p.getName_product()}"></td>
    </tr>
    <tr>
        <td>Price</td>
        <td><input value="${p.getPrice()}"></td>
    </tr>
    <tr>
        <td>Origin</td>
        <td><input value="${p.getOrigin()}"></td>
    </tr>
    <tr>
        <td>Description</td>
        <td><input value="${p.getDescription()}"></td>
    </tr>
    <tr>
        <td><input type="submit" value="Delete"></td>
    </tr>
</table>
</body>
</html>
