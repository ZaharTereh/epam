<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Result page</title>
</head>
<body>
<% List<List<String>> tariffs = (List<List<String>>) request.getAttribute("list");
 for(List<String> object:tariffs){
    for (String info:object){
        %><%=info + " "%><%
  }
}%>
</body>
</html>