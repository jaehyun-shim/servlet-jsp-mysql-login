<%--
  Created by IntelliJ IDEA.
  User: shim
  Date: 2018. 11. 18.
  Time: PM 5:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="inc/head.jsp" %>

<body class="bg-dark">

<div class="container">
    <div class="card card-login mx-auto mt-5">
        <div class="card-header">Login</div>
        <div class="card-body">
            <form action='Login' method="post">
                <div class="form-group">
                    <div class="form-label-group">
                        <input type="email" name="email" id="inputEmail" class="form-control"
                               placeholder="Email address" required="required" autofocus="autofocus">
                        <label for="inputEmail">Email address</label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <input type="password" name="password" id="inputPassword" class="form-control"
                               placeholder="Password" required="required">
                        <label for="inputPassword">Password</label>
                    </div>
                </div>
                <div class="form-group">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" value="remember-me">
                            Remember Password
                        </label>
                    </div>
                </div>
                <input class="btn btn-primary btn-block" type="submit" value="Login"/>
            </form>
            <div class="text-center">
                <a href="#registerModal" id="registerLink">Register</a>
            </div>
        </div>
    </div>
</div>

<%@include file="inc/register.jsp" %>

<script src="/vendor/jquery/jquery.min.js"></script>
<script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="/vendor/jquery-easing/jquery.easing.min.js"></script>

<script>
    $(document).ready(function () {
        $("#registerLink").click(function () {
            $("#registerModal").modal();
        });
    });
</script>
</body>
</html>