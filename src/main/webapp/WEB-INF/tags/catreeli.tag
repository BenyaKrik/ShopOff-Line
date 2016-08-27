<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="mt" %>

<%@attribute name="categories" type="java.util.List" required="true" %>
<%@attribute name="recursive" type="Boolean"%>
<%@attribute name="ots" type="String"%>


<c:if test="${not empty categories}">
    <ul>
         <% ots = "&nbsp;&nbsp;"+ ots ; %>
        <c:forEach items="${categories}" var="category">

            <li>
                <option value="${category.id}">${ots} ${category.name}</option>
                <c:if test="${recursive}">
                    <mt:catreeli categories="${category.categoryList}" recursive="true" ots= "${ots}"/>
                </c:if>
            </li>
        </c:forEach>
    </ul>
    
   
</c:if>