<%--
  Created by IntelliJ IDEA.
  User: shim
  Date: 2018. 11. 18.
  Time: PM 5:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="modal fade" id="registerModal" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="card card-register mx-auto mt-5">
                <div class="card-header">Register an Account</div>

                <div class="card-body">
                    <form action='Register' method="post" id="regForm">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12">
                                    <div class="form-label-group">
                                        <input type="text" name="username" id="userName" class="form-control"
                                               placeholder="First name" required="required" autofocus="autofocus">
                                        <label for="userName">User name</label>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12">
                                    <div class="form-label-group">
                                        <input type="email" name="email" id="email" class="form-control"
                                               placeholder="Email address" required="required">
                                        <label for="email">Email address</label>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <div class="form-label-group">
                                        <input type="password" name="password" id="password" class="form-control"
                                               placeholder="Password" required="required">
                                        <label for="password">Password</label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-label-group">
                                        <input type="password" name="confirmPassword" id="confirmPassword"
                                               class="form-control" placeholder="Confirm password" required="required">
                                        <label for="confirmPassword">Confirm password</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <input class="btn btn-primary btn-block" type="submit" value="Register"/>
                    </form>
                </div>

                <div class="card-footer">
                    <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span
                            class="glyphicon glyphicon-remove"></span> Cancel
                    </button>
                </div>

            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $("#regForm").validate({
            rules: {
                confirmPassword:
                    {
                        equalTo: "#password"
                    }
            }
        });
    });
</script>