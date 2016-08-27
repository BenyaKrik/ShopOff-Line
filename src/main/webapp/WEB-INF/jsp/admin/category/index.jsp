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
                <h1>Shop Off-Line</h1>
            </div>

            <div class="row">
                <div class="col-md-3">
                    <section class="panel panel-primary">
                        <header class="panel-heading">
                            <h4 class="panel-title">Categories</h3>
                        </header>
                        <div class="panel-body">
                            <mt:catreen categories="${categories}" recursive="true" />
                        </div>
                    </section>
                </div>
                <div class="col-md-9">

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
        </div>

        <%@include file="/WEB-INF/jspf/js.jspf" %>
    </body>
</html>
