<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ERROR</title>
</head>
<body>
<jsp:include page="/View/JspHeader.jsp"></jsp:include>
<h1>ERROR</h1>
<hr>
<p><%= request.getParameter("nowErrorMessage") %></p>
</body>
</html>