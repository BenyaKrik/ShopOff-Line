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
            <form action="/files/upload" method="post" enctype="multipart/form-data">

                <label for="uploadFile">Select File to Upload:</label>
                <input id="uploadFile" type="file" name="file" />

                <br/>

                <input type="submit" value="Upload" />

            </form>

        </div>
        <%@include file="/WEB-INF/jspf/js.jspf" %>

        <script type="text/javascript">
            var msg = "${message}";

            if (msg.length > 0) {
                alert(msg);
            }
        </script>
    </body>
</html>
