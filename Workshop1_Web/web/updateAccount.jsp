<%-- 
    Document   : updateAccount
    Created on : Jun 21, 2024, 4:45:25 PM
    Author     : Nhatthang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Add a new account form</title>
        <link href="assets/css/registerStyle.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file="header.jspf"%>
        <c:set var="uAcc" value="${requestScope.uAcc}" />
        <div class="row mg-0">
            <div class="col-md-12">
                <form action="DispatcherAccountServlet" method="post" onsubmit="return validatePhone()">
                    <h2> Update account info </h2>

                    <p class="text-danger">${requestScope.usernameError}</p>
                    <label for="username">Account: </label>
                    <input type="text" id="username" name="username" value="${uAcc.username}" readonly>

                    <label for="password">Password:</label>
                    <input type="password" id="password" value="${uAcc.password}" name="password" required>

                    <label for="lastName">Last Name: </label>
                    <input type="text" id="lastName" name="lastName" value="${uAcc.lastName}">

                    <label for="firstName">First Name: </label>
                    <input type="text" id="firstName" name="firstName" value="${uAcc.firstName}" required>

                    <label for="dob">Birthday</label>
                    <input type="date" id="dob" name="dob" value="${uAcc.dob}" required>

                    <div class="row mg-bot-10">
                        <div class="col-md-6">
                            <label>Gender:</label><br>
                            <label for="male" class="light">
                                <input id="male" type="radio" value="1" name="gender" ${uAcc.gender ? 'checked' : ''} required>Male</label>
                            <label for="female" class="light"></label>
                            <input id="female" type="radio" value="0" name="gender" ${uAcc.gender ? '' : 'checked'} required>Female<br>
                        </div>
                        <div class="col-md-6">
                            <label class="remember-me-label" for="isActive">
                                Is active: 
                                <input type="checkbox" class="mg-0 remember-me-checkbox" id="isActive" name="isActive" ${uAcc.isActive ? '' : 'checked'}>
                            </label>

                        </div>
                    </div>

                    <p id="phoneError" class="text-danger">${requestScope.phoneError}</p>
                    <label for="phone">Phone Number: </label>
                    <input type="tel" id="phone" name="phone" value="${uAcc.phone}" required>


                    <label for="roleInSystem" class="form-label">Role in system: </label>
                    <select class="form-select" id="role" name="role" required>
                        <option value="1" ${uAcc.role == 1 ? 'selected' : ''}>Manager</option>
                        <option value="2" ${uAcc.role == 1 ? '' : 'selected'}>Staff</option>
                    </select> <br><br>
                    <div class="row mg-0">
                        <div class="col-md-6">
                            <button type="submit" name="action" value="updateAccount">Update</button>
                        </div>
                        <div class="col-md-6">
                            <a href="DispatcherAccountServlet?action=showAccountList"><button class="btn-danger" type="button">Cancel</button></a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <script>
            function validatePhone() {
                var phone = document.getElementById('phone').value;
                var phoneRegex = /^(03|05|07|09)\d{8}$/;
                var errorDiv = document.getElementById('phoneError');

                if (!phoneRegex.test(phone)) {
                    errorDiv.textContent = 'Invalid phone number. The phone number must start with 03, 05, 07, or 09 and must be exactly 10 digits long.';
                    return false; // Ngăn chặn gửi form
                } else {
                    errorDiv.textContent = ''; // Xóa bất kỳ thông báo lỗi nào nếu số điện thoại hợp lệ
                }
                return true; // Cho phép gửi form
            }
        </script>
    </body>
</html>
