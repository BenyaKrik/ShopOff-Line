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
                <h1>Shop Off-Line</h1>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <table class="table table-striped table-hover">
                        <thead>

                        <th>#</th>
                        <th>Brand</th>
                        <th>Model</th>
                        <th>Cost</th>
                        <th>Price</th>
                        <th>Quantity</th>

                        </thead>
                        <tbody>

                            <c:forEach items="${cart.keySet()}" var="phone">
                                <tr>

                                    <td>${phone.id}</td>
                                    <td>${phone.brand.name}</td>
                                    <td>${phone.model}</td>
                                    <td><fmt:formatNumber value="${phone.cost}" type="currency" currencySymbol="₴" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    <td><fmt:formatNumber value="${phone.cost + 100}"  type="currency" currencySymbol="$" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    <td>${cart.get(phone)}</td>
                                </tr>
                            </c:forEach>
                            <c:if test="${empty cart}">
                                <tr><td colspan="6" align="center"><h3>Cart is empty now.</h3></td></tr>
                            </c:if>
                        </tbody>

                    </table>

                </div>
            </div>
            <%@include file="/WEB-INF/jspf/js.jspf" %>
    </body>
</html>
