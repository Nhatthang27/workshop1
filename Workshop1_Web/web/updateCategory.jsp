<%-- 
    Document   : updateCategory
    Created on : Jun 22, 2024, 11:42:46 AM
    Author     : Nhatthang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Category Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link href="assets/css/editStyle.css" rel="stylesheet" type="text/css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
    <%@include file="header.jspf"%>
    <div class="container">
        <h1 class="text-center">Update Category</h1>
        <div class="panel panel-default">
            <div class="panel-heading">Fill Category Information</div>
            <div class="panel-body">
                <form action="DispatcherProductServlet" method="post">
                    <input type="hidden" id="categoryId" name="categoryId" value="${param.categoryId}">
                    <div class="form-group">
                        <p id="categoryError" class="text-danger">${requestScope.errorCategoryName}</p>
                        <label for="categoryName">Category Name</label>
                        <input type="text" class="form-control" id="categoryName" name="categoryName" value="${param.categoryName}" required>
                    </div>
                    <div class="form-group">
                        <label for="categoryNote">Note</label>
                        <textarea id="categoryNote" name="categoryNote" rows="5" cols="20">${param.categoryNote}</textarea>
                    </div>
                    <button type="submit" class="btn btn-success" name="action" value="updateCategory">Save Changes</button>
                    <a href="DispatcherProductServlet?action=showCategoryList" class="btn btn-primary">Back to Category List</a>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
