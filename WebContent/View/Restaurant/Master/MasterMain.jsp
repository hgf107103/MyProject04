<%@ page import="Model.UserModel.UserVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레스토랑 : 마스터</title>
<%
	UserVO uv = (UserVO)session.getAttribute("mylogin");
	if(!uv.getId().equals("admin")) {
		response.sendRedirect("/");
	}
%>
</head>
<body>
<jsp:include page="/View/JspHeader.jsp"></jsp:include>
<h1>레스토랑 마스터 화면입니다.</h1>
<a href="/Restaurant/Master/Menu"><button>메뉴 관리</button></a>
<h2>테이블 관리</h2>
<jsp:include page="/View/JspFooter.jsp"></jsp:include>
</body>
</html>