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
<title>마스터 : 메뉴 관련 페이지</title>
</head>
<body>
<jsp:include page="/View/JspHeader.jsp"></jsp:include>

<button id="menuAddButton">메뉴 추가</button>

<jsp:include page="/View/JspFooter.jsp"></jsp:include>
</body>
</html>