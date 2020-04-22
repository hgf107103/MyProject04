<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
<h1>練習用スプリング掲示板</h1>
<hr>
<% if(session.getAttribute("nowLoginID") != null) {%>
<a href="postboard/postboard.jsp"><button>掲示板に移動</button></a>
<%} else {%>
<p>ログインしてください。</p>
<%} %>
</body>
</html>