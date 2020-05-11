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
<script type="text/javascript" src="/View/Restaurant/Master/Menu/JS/MenuPopUpScript.js"></script>
</head>
<body>
<jsp:include page="/View/JspHeader.jsp"></jsp:include>
<button id="showMenuButton">전체 메뉴 확인</button>
<br>
<button id="menuAddButton" onclick="MenuAddPopUp('<%=uv.getId()%>')">메뉴 추가</button>

<jsp:include page="/View/JspFooter.jsp"></jsp:include>
</body>
</html>