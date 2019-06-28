<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="by.training.epam.task4xml.controller.ControllerServlet" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>
<form action="parse" method="get" enctype="multipart/form-data">
    <div>
        Select XML file:
        <br>
        <input name="XMLFile" type="file">
        <br>
    </div>
    <br>
    Select XML parser:
    <p><select name="select" required>
        <option value="DOM">DOM</option>
        <option value="SAX">SAX</option>
        <option value="STAX">STAX</option>
    </select></p>
    <p><input type="submit" value="Parse"></p>
</form>
</body>
</html>