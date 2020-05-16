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
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gamja+Flower&display=swap" rel="stylesheet">
<link rel="stylesheet" href="/View/JspHeaderCSS.css">
<style type="text/css">
	body {
		width: 400px;
		padding: 25px;
		padding-top: 0px;
		margin: auto;
		text-align: center;
		border-right: 1px solid black;
		border-left: 1px solid black;
	}
	div {
		padding-top: 30px;
		padding-bottom: 30px;
		font-weight: normal;
		cursor: default;
	}
	h1 {
		font-family: "Black Han Sans";
		margin-bottom: 60px;
		font-size: 40px;
		font-weight: normal;
		color: rgb(0, 0, 0);
		transition: all ease 0.5s 0s;
	}
	h1:hover {
		color: rgb(150, 150, 150);
		transition: all ease 0.5s 0s;
	}
	button {
		margin-top: 10px;
		font-size: 40px;
		font-family: "Gamja Flower";
		font-weight: bold;
		color: rgb(200, 200, 200);
		background: none;
		border: 1px solid rgb(255, 255, 255);
		padding: 10px;
		transition: all ease 0.5s 0s;
		cursor: pointer;
	}
	button:hover {
		color: rgb(0, 0, 0);
		border: 1px solid rgba(180, 180, 180, 0.3);
		box-shadow: 0 0 0 3px rgba(180, 180, 180, 0.3);
		transition: all ease 0.5s 0s;
	}
	button:focus {
		outline: none;
	}
</style>
<script type="text/javascript" src="/View/Restaurant/Master/Table/JS/TablePopUpScript.js"></script>
</head>
<body>
<jsp:include page="/View/JspHeader.jsp"></jsp:include>

<div>
	<h1>마스터 : 고객 관리</h1>
	<button id="showTableButton" onclick="TableShowPopUp('<%=uv.getId()%>')">테이블 상세</button>
	<br>
	<button id="showUserButton" onclick="alert('아직 없음')">유저 명단</button>
	<br>
	<button id="showSellButton" onclick="alert('아직 없음')">가게 장부</button>
</div>

<jsp:include page="/View/JspFooter.jsp"></jsp:include>
</body>
</html>