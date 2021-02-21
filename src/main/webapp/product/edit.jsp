<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/21/2021
  Time: 11:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<form method="post"></form>
<a href="/products">List product</a>
<table>
    <tr>
        <td>Name</td>
        <td><input type="text" name="name" value="${p.getName_product()}"></td>
    </tr>
    <tr>
        <td>Price</td>
        <td><input type="text" name="price" value="${p.getPrice()}"></td>
    </tr>
    <tr>
        <td>Origin</td>
        <td><input type="text" name="origin" value="${p.getOrigin()}"></td>
    </tr>
    <tr>
        <td>Description</td>
        <td><input type="text" name="description" value="${p.getDescription()}"></td>
    </tr>
    <tr>
        <td><input type="submit" value="Edit"></td>
    </tr>
</table>
</body>
</html>
