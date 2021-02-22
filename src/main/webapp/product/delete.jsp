
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>
<h1>Delete  product</h1>
<form method="post">
<a href="/products">List product</a>
<table>
    <tr>
        <td>Name</td>
        <td><input name="name_product" value="${p.getName_product()}"></td>
    </tr>
    <tr>
        <td>Price</td>
        <td><input name="price" value="${p.getPrice()}"></td>
    </tr>
    <tr>
        <td>Origin</td>
        <td><input name="origin" value="${p.getOrigin()}"></td>
    </tr>
    <tr>
        <td>Description</td>
        <td><input name="description" value="${p.getDescription()}"></td>
    </tr>
    <tr>
        <td><input type="submit" value="Delete"></td>
    </tr>
</table>
</form>
</body>
</html>
