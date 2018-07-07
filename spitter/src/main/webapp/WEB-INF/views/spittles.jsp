<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><s:message code="spittles.title"/></title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css" />"/>
</head>
<body>
<h1><s:message code="spittles.recent"/>:</h1>
<ul>
    <c:forEach items="${spittleList}" var="spittle">
        <li id="spittle_<c:out value="${spittle.id}"/>">
            <div class="spittleMessage">
                <c:out value="${spittle.message}"/>
            </div>
            <div>
                <span class="spittleTime"><c:out value="${spittle.time}"/></span>
                <span class="spittleLocation">
(<c:out value="${spittle.latitude}"/>,
<c:out value="${spittle.longitude}"/>)
            </span>
            </div>
        </li>
    </c:forEach>
</ul>
</body>
</html>
