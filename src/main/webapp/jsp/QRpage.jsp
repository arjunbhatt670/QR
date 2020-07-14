<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%--<script>alert("hello");</script>--%>
<body>
<%
    response.setHeader("Cache-control","no-cache");
    response.setHeader("Cache-control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader("Expire",0);
%>
    <h1>
        Welcome ${Again} ${name}
    </h1>

    <h2>this is your qr code</h2>
    <img src="data:image/jpg;base64,${image}" width="250" height="250"/>

<a href="jsp/logout.jsp">Logout</a>



</body>
</html>