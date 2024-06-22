<%-- 
    Document   : accountList
    Created on : Jun 20, 2024, 11:41:30 PM
    Author     : Nhatthang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account List Page</title>
        <link href="assets/css/accountListStyle.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file="header.jspf"%> 
        <h1 class="text-center">Account Management</h1>

        <div class="container" style="padding: 0">
            <form action="DispatcherAccountServlet" method="POST">
                <button type="submit" class="btn btn-info btn-sm px-3" name="action" value="addAccountPage">
                    Add a new account
                </button>
            </form>
        </div>
        <section class="intro">
            <div class="bg-image h-100" style="background-color: white;">
                <div class="mask d-flex h-100">
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-12">
                                <div class="card shadow-2-strong" style="background-color: #f5f7fa;">
                                    <div class="card-body">
                                        <div class="table-responsive">
                                            <table class="table table-borderless mb-0">
                                                <thead>
                                                    <tr>
                                                        <th scope="col">ACCOUNT</th>
                                                        <th scope="col">FULL NAME</th>
                                                        <th scope="col">DATE OF BIRTH</th>
                                                        <th scope="col">GENDER</th>
                                                        <th scope="col">PHONE</th>
                                                        <th scope="col">ROLE</th>
                                                        <th scope="col">ACTION</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${requestScope.accounts}" var="acc">
                                                        <tr>
                                                            <td>${acc.username}</td>
                                                            <td>${acc.firstName} ${acc.lastName}</td>
                                                            <td>${acc.dob}</td>
                                                            <td>${acc.gender ? 'Male' : 'Female'}</td>
                                                            <td>${acc.phone}</td>
                                                            <td>${acc.role == 1 ? 'Manager' : 'Staff'}</td>
                                                            <td>
                                                                <form action="DispatcherAccountServlet" method="POST">
                                                                    <input type="hidden" name="username" value="${acc.username}">
                                                                    <input type="hidden" name="isActive" value="${acc.isActive ? '1' : '0'}">
                                                                    <button type="submit" class="btn btn-primary btn-sm px-3" name="action" value="getAccountInfo">
                                                                        Update
                                                                    </button>
                                                                    <button type="submit" class="btn btn-danger btn-sm px-3" name="action" value="deleteAccount">
                                                                        Delete
                                                                    </button>
                                                                    <button type="submit" class="btn btn-success btn-sm px-3" name="action" value="activeAccount">
                                                                        ${acc.isActive ? 'Deactive' : 'Active'}
                                                                    </button>
                                                                </form>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
