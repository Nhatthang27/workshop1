<%-- 
    Document   : categoryList
    Created on : Jun 22, 2024, 3:50:56 AM
    Author     : Nhatthang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Category Management</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file="header.jspf"%> 

        <div class="container">
            <h1 class="text-center">Category Management</h1>
            <form action="DispatcherProductServlet" method="POST" style="padding: 0">
                <button type="submit" class="btn btn-info btn-sm px-3" name="action" value="addCategoryPage">
                    Add a new category
                </button>
            </form>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Note</th>
                        <th>Action</th>    
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.categories}" var="cate"> 
                        <tr>
                            <td>${cate.categoryId}</td>
                            <td>${cate.categoryName}</td>
                            <td>${cate.note}</td>

                            <td>
                                <form action="DispatcherProductServlet" method="POST">
                                    <input type="hidden" id="categoryId" name="categoryId" value="${cate.categoryId}">
                                    <input type="hidden" id="categoryName" name="categoryName" value="${cate.categoryName}">
                                    <input type="hidden" id="categoryNote" name="categoryNote" value="${cate.note}">
                                    <button  class="btn btn-primary btn-sm" name="action" value="updateCategoryPage">Update</button>
                                    <button  class="btn btn-danger btn-sm" name="action" value="deleteCategory">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>

