<%-- 
    Document   : productDetail
    Created on : Jun 22, 2024, 2:45:33 PM
    Author     : Nhatthang
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Product Details</title>
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
            <h1 class="text-center">Product Details</h1>
            <div class="panel panel-default">
                <div class="panel-heading">Product Information</div>
                <div class="panel-body">
                    <div class="row">
                        <!-- Left column for product information -->
                        <div class="col-md-7">
                            <form>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-md-4">
                                            <label for="productId">Product ID</label>
                                            <input type="text" class="form-control" id="productId" value="${requestScope.prd.productId}" readonly>
                                        </div>
                                        <div class="col-md-8">
                                            <label for="productName">Product Name</label>
                                            <input type="text" class="form-control" id="productName" value="${requestScope.prd.productName}" readonly>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-md-4">
                                            <label for="productPrice">Price</label>
                                            <input type="text" class="form-control" id="productPrice" value="${requestScope.prd.price}" readonly>
                                        </div>
                                        <div class="col-md-4">
                                            <label for="productDiscount">Discount</label>
                                            <input type="text" class="form-control" id="productDiscount" value="${requestScope.prd.discount}" readonly>
                                        </div>
                                        <div class="col-md-4">
                                            <label for="productQuantity">Quantity</label>
                                            <input type="text" class="form-control" id="productQuantity" value="${requestScope.prd.quantity}" readonly>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-md-4">
                                            <label for="poster">Poster</label>
                                            <input type="text" class="form-control" id="poster" value="${requestScope.prd.account.username}" name="poster" readonly>
                                        </div>
                                        <div class="col-md-4">
                                            <label for="postdate">Post Date</label>
                                            <input type="text" class="form-control" id="postdate" value="${requestScope.prd.postedDate}" name="postdate" readonly>
                                        </div>
                                        <div class="col-md-4">
                                            <label for="category">Category</label>
                                            <input type="text" class="form-control" id="category" value="${requestScope.prd.category.categoryName}" name="postdate" readonly>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="brief">Brief</label>
                                    <textarea style="text-align: left" id="brief" name="brief" rows="10" cols="85" readonly>${requestScope.prd.brief}</textarea>
                                </div>
                                <a href="DispatcherProductServlet?action=showProductList" class="btn btn-primary">Back to Product List</a>

                            </form>
                        </div>
                        <div class="col-md-5 text-center">
                            <img src="images/sanPham/${requestScope.prd.productImage}" alt="Product Image" class="product-image">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
