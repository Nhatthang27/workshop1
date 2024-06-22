<%-- 
    Document   : updateProduct
    Created on : Jun 22, 2024, 4:40:32 PM
    Author     : Nhatthang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Update Product Form</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <style>
            .product-image {
                max-width: 100%;
                height: auto;
            }
        </style>
    </head>
    <body>
        <%@include file="header.jspf"%> 
        <div class="container">
            <h1 class="text-center">Update Product</h1>
            <div class="panel panel-default">
                <div class="panel-heading">Product Information</div>
                <div class="panel-body">
                    <div class="row">
                        <!-- Left column for product information -->
                        <div class="col-md-7">
                            <form action="DispatcherProductServlet" method="POST">
                                <input type="hidden" id="productImage" name="productImage" value="${requestScope.prd.productImage}">
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-md-4">
                                            <label for="productId">Product ID</label>
                                            <input type="text" class="form-control" id="productId" value="${requestScope.prd.productId}" name="productId" readonly>
                                        </div>
                                        <div class="col-md-8">
                                            <label for="productName">Product Name</label>
                                            <input type="text" class="form-control" id="productName" value="${requestScope.prd.productName}" name="productName" required>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-md-4">
                                            <label for="price">Price</label>
                                            <input type="number" min="1" step="1" class="form-control" id="price" name="price" value="${requestScope.prd.price}" required>
                                        </div>
                                        <div class="col-md-4">
                                            <label for="discount">Discount</label>
                                            <input type="number" min="0" step="1" class="form-control" id="discount" name="discount" value="${requestScope.prd.discount}">
                                        </div>
                                        <div class="col-md-4">
                                            <label for="quantity">Quantity</label>
                                            <input type="number" min="0" step="1" class="form-control" id="quantity" name="quantity" value="${requestScope.prd.quantity}" required>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-md-4">
                                            <label for="account">Poster</label>
                                            <input type="text" class="form-control" id="account" value="${requestScope.prd.account.username}" name="account" readonly>
                                        </div>
                                        <div class="col-md-4">
                                            <label for="postedDate">Posted Date</label>
                                            <input type="text" class="form-control" id="postedDate" value="${requestScope.prd.postedDate}" name="postedDate" readonly>
                                        </div>
                                        <div class="col-md-4">
                                            <label for="category">Category</label>
                                            <select class="form-control" id="category" name="category">
                                                <c:forEach items="${requestScope.categories}" var="cate">
                                                    <option value="${cate.categoryId}" ${requestScope.prd.category.categoryId == cate.categoryId ? 'selected' : ''}>${cate.categoryName}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="brief">Brief</label>
                                    <textarea id="brief" name="brief" rows="10" cols="85">${requestScope.prd.brief}</textarea>
                                </div>
                                <button type="submit" class="btn btn-success" name="action" value="updateProduct">Save Changes</button>
                                <a href="DispatcherProductServlet?action=showProductList" class="btn btn-primary">Back to Product List</a>
                            </form>
                        </div>
                        <!-- Right column for product image -->
                        <div class="col-md-5 text-center">
                            <img src="images/sanPham/${requestScope.prd.productImage}" alt="Product Image" class="product-image">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

