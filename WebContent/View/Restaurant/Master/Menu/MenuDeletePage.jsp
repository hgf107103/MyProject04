<%@ page import="Model.UserModel.UserVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	UserVO uv = (UserVO)session.getAttribute("mylogin");
	if(!uv.getId().equals("admin")) {
		response.sendRedirect("/");
	}
%>
<title>마스터 : 메뉴삭제</title>
</head>
<body>

</body>
</html>