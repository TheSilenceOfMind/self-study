<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> <%-- sf - means Spring Form --%>

<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ page import="java.util.ResourceBundle" %>
<% ResourceBundle resource = ResourceBundle.getBundle("messages");
    String registerButtonText = resource.getString("home.register"); %>

<html>
<head>
    <title><s:message code="common.title"/></title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style.css" />">
</head>
<body>
<h1><s:message code="register.register"/></h1>
<sf:form method="POST" commandName="spitter">
    <sf:errors path="*" cssClass="errors" element="div"/>

    <sf:label path="firstName" cssErrorClass="error">
        <s:message code="register.firstName"/>
    </sf:label>:
    <sf:input path="firstName" cssErrorClass="error"/><br/>

    <sf:label path="lastName" cssErrorClass="error">
        <s:message code="register.lastName"/>
    </sf:label>:
    <sf:input path="lastName" cssErrorClass="error"/><br/>

    <sf:label path="username" cssErrorClass="error">
        <s:message code="register.nickname"/>
    </sf:label>:
    <sf:input path="username" cssErrorClass="error"/><br/>

    <sf:label path="password" cssErrorClass="error">
        <s:message code="register.password"/>
    </sf:label>:
    <sf:password path="password" cssErrorClass="error"/><br/>

    <input type="submit" value="<%=registerButtonText%>"/>
</sf:form>
</body>
</html>