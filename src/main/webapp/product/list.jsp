<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<button><a href="/products?action=create">Create new product</a></button>
<form action="/products">
    <input value="search" name="action" hidden>
    <input type="text" name="name_product" placeholder="Nhập tên">
    <input type="submit" value="Tìm kiếm">
</form>

<table border="2px">
    <tr>
        <td>Name</td>
        <td>Price</td>
        <td>Origin</td>
        <td>Descripption</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${p}" var="product">
        <tr>
            <td>${product.getName_product()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getOrigin()}</td>
            <td>${product.getDescription()}</td>
            <td><a href="/products?action=edit&id=${product.getId()}">Edit</a></td>
            <td><a href="/products?action=delete&id=${product.getId()}">Delete</a></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
