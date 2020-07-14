<%--
  Created by IntelliJ IDEA.
  User: arjun
  Date: 09-07-2020
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    session.invalidate();
    response.sendRedirect("../index.jsp");
%>
</body>
</html>
