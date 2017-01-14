<%-- 
    Document   : index
    Created on : Sep 24, 2016, 7:50:22 PM
    Author     : Alexandre
--%>

<%@page import="Model.VO.userVO"%>
<%@ page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/core" %>

<c:out value="${user.username}"/>
<html>
    <head>
    </head>
    <body>
        <c:import url="appbar.jsp"/>
    </body>
</html>