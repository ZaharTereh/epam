<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Result page</title>
</head>
<body>
<h1 align=\"centre\">Parsed by ${parser}</h1>
<table border="1" width="40%" align="center">

    <tr align=\"center\">
        <td>Payroll</td>
        <td>Registration</td>
        <td>Tariff</td>
        <td>Operator</td>
        <td>Megabytes</td>
        <td>Price For One MB</td>
        <td>Connect price</td>
        <td>Number</td>
        <td>Inside call</td>
        <td>Outside call</td>
        <td>Lendline call</td>
        <td>Free minutes</td>
        <td>Sms price</td>
        <td>Sms max length</td>
        <td>Tariffication</td>
        <td>Like numbers</td>
    </tr>
    <c:forEach items="${list}" var="objects" varStatus="status">
        <tr align=\"center\">
        <c:forEach items="${objects}" var="object" varStatus="status">
            <td><c:out value="${object}"/></td>
        </c:forEach>
        </tr>
    </c:forEach>

</table>
</body>
</html>