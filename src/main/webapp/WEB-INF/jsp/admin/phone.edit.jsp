<%-- 
    Document   : phone.add
    Created on : Jul 14, 2016, 10:31:28 AM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h1>ADD NEW PHONE</h1>

            <div class="panel panel-blue margin-bottom-40">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="fa fa-tasks"></i> Basic Form</h3>
                </div>
                <div class="panel-body">
                    <form method="post" class="margin-bottom-40">
                        <div class="form-group">
                            <label  >Brand:</label>
                            <select name="brand_id" class="form-control">
                                <c:forEach items="${brandList}" var="brand">
                                    <option value="${brand.id}" ${foundPhone.brand.id == brand.id ? 'selected' : ''}>${brand.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Model:</label>
                            <input class="form-control" type="text" name="model" value="${foundPhone.model}" />
                        </div>
                        <div class="form-group">
                            <label>Body:</label>
                            <textarea class="form-control" name="body">${foundPhone.body}</textarea>
                        </div>
                        <div class="form-group">
                            <label>Cost:</label>
                            <input class="form-control" type="text" name="cost" value="${foundPhone.cost}" />
                        </div>
                        <div class="form-group">
                            <div  class="col-lg-2"> <a href="${pageContext.servletContext.contextPath}/admin/showcase">&lt; back to table</a></div>
                            <div  class="col-lg-2"> <button type="submit" class="btn-u btn-u-blue">Save</button></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <%@include file="/WEB-INF/jspf/js.jspf" %>
    </body>
</html>
