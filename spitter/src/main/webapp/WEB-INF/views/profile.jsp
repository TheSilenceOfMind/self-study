<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><s:message code="profile.title" /></title>
</head>
<body>
<h1><s:message code="profile.yourProfile" /></h1>
<c:out value="${spitter.username}"/><br/>
<c:out value="${spitter.firstName}"/>
<c:out value="${spitter.lastName}"/>
</body>
</html>
