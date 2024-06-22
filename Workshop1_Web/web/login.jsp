<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : login
    Created on : Jun 14, 2024, 5:48:21 PM
    Author     : Nhatthang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Login Form</title>
        <link href="assets/css/loginStyle.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="row mg-0">
            <div class="col-md-12">
                <form action="DispatcherAccountServlet" method="post">
                    <h2> Sign in </h2>
                    
                    <p class="text-danger">${requestScope.error}</p>
                    <label for="username">Account: </label>
                    <input type="text" id="username" name="username" value="${cookie.username.value}">

                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" value="${cookie.password.value}">

                    <button type="submit" value="login" name="action">Login</button>

                    <label for="rmb" class="remember-me-label">
                        Remember me: 
                        <input type="checkbox" id="rmb" class="mg-0 remember-me-checkbox" name="rmb" value="1" 
                               ${empty cookie.rmb ? "" : "checked"}>
                    </label>
                   
                </form>
                
                
            </div>
        </div>
        
        
    </body>
</html>