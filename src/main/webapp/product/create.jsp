<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/21/2021
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Creat Product</title>
</head>
<body>
<a href="/products">List Product</a>
<form method="post"></form>
<table>
    <tr>
        <td>Name</td>
        <td><input type="text" name="name" placeholder="nhập tên"></td>
    </tr>
    <tr>
        <td>Price</td>
        <td><input type="text" name="price" placeholder="nhập giá"></td>
    </tr>
    <tr>
        <td>Origin</td>
        <td><input type="text" name="origin" placeholder="nhập xuất sứ"></td>
    </tr>
    <tr>
        <td>Description</td>
        <td><input type="text" name="description" placeholder="nhập mô tả"></td>
    </tr>
    <tr>
        <td><input type="submit" value="create"></td>
    </tr>
</table>
</body>
</html>
