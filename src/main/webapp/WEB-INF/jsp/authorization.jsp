<%-- 
    Document   : index
    Created on : Jul 7, 2016, 10:42:50 AM
    Author     : pavel
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <%@include file="/WEB-INF/jspf/css.jspf" %>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/header.menu.jspf" %>
        
        <div class="container">
            <div class="page-header">
                <h1>Authorization</h1>
            </div>

            <div class="row">
                <div class="col-md-6 col-lg-offset-3">
                    <form action="${pageContext.servletContext.contextPath}/auth" method="post" class="form-horizontal">
                        <div class="form-group">
                            <label class="control-label col-md-3">Username:</label>
                            <div class="col-md-9">
                                <input type="text" name="username" class="form-control" placeholder="Your username" value="${username}" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Password:</label>
                            <div class="col-md-9">
                                <input type="password" name="password" class="form-control" placeholder="Your password" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="text-right">
                                <button class="btn btn-default">Sign up</button>
                                <button class="btn btn-primary">Sign in</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <%@include file="/WEB-INF/jspf/js.jspf" %>
    </body>
</html>
