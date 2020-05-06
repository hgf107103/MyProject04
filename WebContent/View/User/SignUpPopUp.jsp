<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID Cheak</title>
</head>
<body>
<h1>아이디 중복 테스트</h1>
<input type="text" id="popId" value="<%= request.getParameter("id") %>">
<input type="button" id="popCheakId">
</body>
</html>