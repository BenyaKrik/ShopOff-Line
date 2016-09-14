<%-- 
    Document   : index
    Created on : Jul 7, 2016, 10:42:50 AM
    Author     : pavel
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="mt" %>
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
                <h1>Shop Off-Line ${category.name}</h1>
            </div>

            <div class="row">
                <div class="col-md-3 list-group">
                    <c:if test="${not empty categories}">


                        <section class="panel panel-primary">
                            <header class="panel-heading">
                                <h4 class="panel-title">Categories</h3>
                            </header>
                            <div class="panel-body">  
                                <mt:catreen categories="${categories}" recursive="true" />
                            </div>
                        </section>
                    </c:if>
                    <c:forEach items="${brands}" var="brand">

                        <a href="${pageContext.servletContext.contextPath}<c:if test="${not empty category.url}">/category/${category.url}/</c:if>
                           <c:if test="${empty category.url}">/brand/</c:if>${brand.id}"
                           class="list-group-item ${brand.id == param.brand_id ? 'active' : ''}">
                            ${brand.name}
                        </a>

                    </c:forEach>

                </div>
                <div class="col-md-9">

                    <table class="table table-striped table-hover">
                        <thead>

                        <th>#</th>
                        <th>Brand</th>
                        <th>Model</th>
                        <th style="text-align: right;">Price</th>
                        <th style="width: 1%;"></th>

                        </thead>
                        <tbody>

                            <c:forEach items="${products}" var="phone">
                                <tr>

                                    <td>${phone.id}</td>
                                    <td>${phone.brand.name}</td>
                                    <td>${phone.model}</td>
                                    <td style="text-align: right;"><fmt:formatNumber value="${phone.cost*usd}" type="currency" currencySymbol="₴" minFractionDigits="2" maxFractionDigits="2" /></td>
                                    <td>
                                        <form action="${pageContext.servletContext.contextPath}/cart/add" method="post" onsubmit="addToCart(this); return false;">
                                            <input type="hidden" name="productId" value="${phone.id}" />
                                            <button><i class="fa fa-fw fa-cart-plus"></i></button>
                                        </form>
                                    </td>

                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>

                    <div class="modal fade" id="myModal" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Modal Header</h4>
                                </div>
                                <div class="modal-body">
                                    <p>Some text in the modal.</p>
                                    <%@include file="/WEB-INF/jspf/cart.jspf" %>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                </div>
                            </div>

                        </div>
                    </div>

                </div>
            </div>
            <%@include file="/WEB-INF/jspf/js.jspf" %>
    </body>
</html>
