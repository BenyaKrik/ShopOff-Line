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

        <div class="container">
            <%@include file="/WEB-INF/jspf/admin/header.menu.jspf" %>
            <h1>Registration</h1>

            <div class="panel panel-blue margin-bottom-40">
                <div class="panel-body">
                   <h2>${message}<h2/>
                    <form method="post" class="margin-bottom-40">
                        <div class="form-group">
                            <label>Name:</label>
                            <input class="form-control" type="text" name="name" value="" />
                        </div>
                        <div class="form-group">
                            <label>Email:</label>
                              <input class="form-control" type="text" name="email" value="" />
                        </div>
                        <div class="form-group">
                            <label>Password:</label>
                            <input class="form-control" type="password" name="password" value="" />
                        </div>
                        <div class="form-group">
                            <label>Return Password:</label>
                            <input class="form-control" type="password" name="password2" value="" />
                        </div>
                        <div class="form-group">
    
                            <div  class="col-lg-2"> <button type="submit" class="btn-u btn-u-blue">Save</button></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <%@include file="/WEB-INF/jspf/js.jspf" %>
    </body>
</html>
