<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="mt" %>

<%@attribute name="categories" type="java.util.List" required="true" %>
<%@attribute name="recursive" type="Boolean"%>

<c:if test="${not empty categories}">

    <ul>
        <c:forEach items="${categories}" var="category">
            <li>
                <a href="${pageContext.servletContext.contextPath}/category/${category.id}"
                   >
                    ${category.name}
                </a>

                <c:if test="${recursive}">
                    <mt:catreen categories="${category.categoryList}" recursive="true" />
                </c:if>
            </li>
        </c:forEach>
    </ul>
</c:if>