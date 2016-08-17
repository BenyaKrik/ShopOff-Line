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
        <%@include file="/WEB-INF/jspf/admin/header.menu.jspf" %>
        <div class="container">
            <div class="row">
                <div class="col-md-3 list-group">
                    <c:forEach items="${brands}" var="brand">

                        <a href="${pageContext.servletContext.contextPath}/?brand_id=${brand.id}"
                           class="list-group-item ${brand.id == param.brand_id ? 'active' : ''}">
                            ${brand.name}
                        </a>

                    </c:forEach>

                </div>
                <div class="col-md-9">
                    <form action="${pageContext.servletContext.contextPath}/product/remove" method="post">
                        <table class="table table-striped table-hover">
                            <thead>
                            <th></th>
                            <th>#</th>
                            <th>Brand</th>
                            <th>Model</th>
                            <th>Cost</th>
                            <th>Price</th>
                            <th style="width: 1%; text-align: center;">
                                <a href="${pageContext.servletContext.contextPath}/admin/product/add " class="btn btn-xs btn-success"><i class="fa fa-fw fa-plus"></i> add</a>
                            </th>
                            </thead>
                            <tbody>
                                <c:forEach items="${products}" var="phone">
                                    <tr>
                                        <td><input type="checkbox" name="select" value="${phone.id}" /></td>
                                        <td>${phone.id}</td>
                                        <td>${phone.brand.name}</td>
                                        <td>${phone.model}</td>
                                        <td><fmt:formatNumber value="${phone.cost}" type="currency" currencySymbol="$" /></td>
                                        <td>$${phone.cost + 100}</td>
                                        <td nowrap align="right">
                                            <a href="${pageContext.servletContext.contextPath}/admin/product/edit/${phone.id}" class="btn btn-xs btn-warning">
                                                <i class="fa fa-fw fa-edit"></i>
                                            </a>
                                            <a href="${paSgeContext.servletContext.contextPath}/admin/product/remove/${phone.id}" class="btn btn-xs btn-danger"
                                               onclick="return confirm('Do you really want remove \'${phone.brand.name} ${phone.model}\' phone?');">
                                                <i class="fa fa-fw fa-trash"></i>
                                            </a>

                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <td colspan="7">
                                        <button type="submit" class="btn btn-xs btn-danger"><i class="fa fa-fw fa-remove"></i> Remove selected</button>
                                    </td>
                                </tr>
                            </tfoot>
                        </table>
                    </form>
                </div>
            </div>
            <%@include file="/WEB-INF/jspf/js.jspf" %>
    </body>
</html>
