<%-- 
    Document   : productList
    Created on : Jun 22, 2024, 2:45:37 AM
    Author     : Nhatthang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Product Management</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file="header.jspf"%> 
        <div class="container">
            <h1 class="text-center">Product Management</h1>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Discount</th>
                        <th>Quantity</th>
                        <th>Posted Date</th>
                        <th>Action</th>
                            
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.products}" var="prd"> 
                        <tr>
                            <td>${prd.productId}</td>
                            <td>${prd.productName} 1</td>
                            <td>${prd.price}</td>
                            <td>${prd.discount}</td>
                            <td>${prd.quantity}</td>
                            <td>${prd.postedDate}</td>
                            <td>
                                <a href="product-details.html?id=1" class="btn btn-warning btn-sm">Details</a>
                                <a href="edit-product.html?id=1" class="btn btn-primary btn-sm">Edit</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
