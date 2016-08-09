<%-- 
    Document   : brands
    Created on : Jul 18, 2016, 1:48:42 PM
    Author     : user
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Brands Page</title>
        <%@include file="/WEB-INF/jspf/css.jspf" %>
    </head>
    <body>

        <%@include file="/WEB-INF/jspf/admin/header.menu.jspf" %>
        <div class="container">
            <div class="row">

                <div class="col-md-9"> 
                    <table class="table table-striped table-hover"> 
                        <tbody>
                            <c:forEach items="${UserList}" var="users">
                                <tr>
                                    <td>${users.id}</td>
                                    <td>${users.name}</td>
                                    <td>${users.email}</td>
                                    <td>${users.status}</td>
                                    <td nowrap>
                                        <a href="${pageContext.servletContext.contextPath}/admin/user/edit?id=${users.id}" class="btn btn-xs btn-warning">
                                            <i class="fa fa-fw fa-edit"></i>
                                        </a>
                                        <a href="${pageContext.servletContext.contextPath}/admin/user/remove?id=${users.id}" class="btn btn-xs btn-danger"
                                           onclick="return confirm('Do you really want remove \'${users.name} ${users.email}\' brand?');">
                                            <i class="fa fa-fw fa-trash"></i>
                                        </a>

                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>
                </div>
            </div>
            <%@include file="/WEB-INF/jspf/js.jspf" %>
    </body>
</html>
