<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css" />"/>
</head>
<body>
<h1><s:message code="spittr.welcome"/></h1>
<a href="<c:url value="/spittles" />">Spittles</a>|
<a href="<c:url value="/spitter/register" />">Register</a>
</body>
</html>
