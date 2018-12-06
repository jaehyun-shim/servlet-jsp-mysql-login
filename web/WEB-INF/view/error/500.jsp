<%--
  Created by IntelliJ IDEA.
  User: shim
  Date: 2018. 11. 18.
  Time: PM 5:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../inc/head.jsp" %>

<body id="page-top">

<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
    <%@ include file="../inc/header.jsp" %>
</nav>

<div id="wrapper">
    <ul class="sidebar navbar-nav">
        <%@ include file="../inc/leftmenu.jsp" %>
    </ul>

    <div id="content-wrapper">

        <div class="container-fluid">

            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="/">Dashboard</a>
                </li>
                <li class="breadcrumb-item active">500 Error</li>
            </ol>

            <h1 class="display-1">500</h1>
            <p class="lead">Page not found. You can
                <a href="javascript:history.back()">go back</a>
                to the previous page, or
                <a href="/">return home</a>.</p>

        </div>

        <footer class="sticky-footer">
            <%@ include file="../inc/footer.jsp" %>
        </footer>

    </div>
</div>

<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <%@include file="../inc/logout.jsp" %>
</div>

<script src="/vendor/jquery/jquery.min.js"></script>
<script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="/vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="/vendor/datatables/jquery.dataTables.js"></script>
<script src="/vendor/datatables/dataTables.bootstrap4.js"></script>
<script src="/js/sb-admin.min.js"></script>
<script src="/js/demo/datatables-demo.js"></script>

</body>
</html>