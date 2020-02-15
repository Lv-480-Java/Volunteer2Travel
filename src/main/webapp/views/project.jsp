<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 06.02.2020
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Volunteer2Travel</title>
    <link rel="stylesheet" href="/static/css/project.css" type="text/css"/>
</head>
<body>
<div id="projectId">

<%--    <img src="${requestScope.admin_projects.urlImage}">--%>
    <div id="headerPhoto">
        <button class="buttons"><a href="/registration">Sign up</a></button>
        <button class="buttons"><a href="/explore">Explore</a></button>
    </div>
    <div id="description">
        <c:out value="${requestScope.admin_project.name}"/>
    </div>

</div>
</body>
</html>
