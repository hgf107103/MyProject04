<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ERROR</title>
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
	p {
		font-size: 18px;
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
</style>
</head>
<body>
<jsp:include page="/View/JspHeader.jsp"></jsp:include>

<div>
<h1>ERROR</h1>
<p><%= request.getParameter("nowErrorMessage") %></p>
</div>

<jsp:include page="/View/JspFooter.jsp"></jsp:include>
</body>
</html>