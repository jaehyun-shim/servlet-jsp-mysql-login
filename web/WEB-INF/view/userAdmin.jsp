<%--
  Created by IntelliJ IDEA.
  User: shim
  Date: 2018. 11. 18.
  Time: PM 5:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="inc/head.jsp" %>

<body id="page-top">

<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
    <%@ include file="inc/header.jsp" %>
</nav>

<div id="wrapper">
    <ul class="sidebar navbar-nav">
        <%@ include file="inc/leftmenu.jsp" %>
    </ul>

    <div id="content-wrapper">
        <div class="container-fluid">
            <div class="card mb-3">
                <div class="card-header">
                    <i class="fas fa-table"></i>
                    Data Table Example
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Password</th>
                                <th>Email</th>
                                <th>Update</th>
                                <th>Delete</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${users}" var="user">
                                <tr>
                                    <td><c:out value="${user.userid}"/></td>
                                    <td><c:out value="${user.username}"/></td>
                                    <td><c:out value="${user.password}"/></td>
                                    <td><c:out value="${user.email}"/></td>
                                    <td><a data-toggle="modal" href="#editModal" id="<c:out value="${user.userid}"/>"
                                           class="edit-link">Edit</a></td>
                                    <td><a href="Login?action=remove&userid=<c:out value="${user.userid}"/>">Remove</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                            <tfoot>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Password</th>
                                <th>Email</th>
                                <th>Update</th>
                                <th>Delete</th>
                            </tr>
                            </tfoot>
                        </table>
                    </div>
                </div>
                <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
            </div>

            <p class="small text-center text-muted my-5">
                <em>More table examples coming soon...</em>
            </p>
        </div>

        <footer class="sticky-footer">
            <%@ include file="inc/footer.jsp" %>
        </footer>

    </div>
</div>

<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <%@include file="inc/logout.jsp" %>
</div>

<div class="load-body"></div>
                                              
<script>
    $(document).ready(function () {
        $(".edit-link").click(function () {
            var userid = $(this).attr('id');
            var action = 'edit';
            var data = "action=" + action + "&userid=" + userid;
            $.ajax({
                type: "Get",
                url: 'Login',
                data: data,
                async: false,
                success: function (response) {
                    $(".load-body").html(response);
                },
                error: function () {
                    alert('error');
                },
                complete: function () {
                    $( "#glyphicon-remove-btn" ).trigger( "click" );
                }
            });
        });
    });
</script>

<script src="/vendor/jquery/jquery.min.js"></script>
<script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="/vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="/vendor/datatables/jquery.dataTables.js"></script>
<script src="/vendor/datatables/dataTables.bootstrap4.js"></script>
<script src="/js/sb-admin.min.js"></script>
<script src="/js/demo/datatables-demo.js"></script>

</body>
</html>