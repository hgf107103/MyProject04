<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogIn</title>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gamja+Flower&display=swap" rel="stylesheet">
<style type="text/css">
	body {
		width: 400px;
		padding: 25px;
		margin: auto;
		text-align: center;
		border-right: 1px solid black;
		border-left: 1px solid black;
	}
	button {
		margin-top: 10px;
		font-size: 40px;
		font-family: "Black Han Sans";
		color: rgb(50, 200, 150);
		background: none;
		border: none;
		padding: 10px;
		transition: all ease 1s 0s;
	}
	button:hover {
		color: rgb(255, 200, 200);
		transition: all ease 1s 0s;
	}
	form {
		padding-top: 20px;
		padding-bottom: 50px;
		width: 100%;
		margin: auto;
	}
	input {
		text-align: center;
		margin: auto;
	}
	input[type=text] {
		margin: 10px auto;
		width: 250px;
		padding: 10px 0px;
		font-size: 18px;
		text-decoration: none;
		outline: none;
		border: 1px solid gray;
		transition: all ease 0.5s 0s;
	}
	input[type=text]:focus {
		text-decoration: none;
		box-shadow: 0 0 0 5px rgba(180, 180, 180, 0.3);
		transition: all ease 0.5s 0s;
	}
	input[type=password] {
		margin: 10px auto;
		width: 250px;
		padding: 10px 0px;
		font-size: 18px;
		text-decoration: none;
		outline: none;
		border: 1px solid gray;
		transition: all ease 0.5s 0s;
	}
	input[type=password]:focus {
		text-decoration: none;
		box-shadow: 0 0 0 5px rgba(180, 180, 180, 0.3);
		transition: all ease 0.5s 0s;
	}
	input[type=submit] {
		font-size: 18px;
		width: 100px;
		padding: 10px;
		margin-top: 30px;
		background: none;
		border: 1px solid black;
		cursor: pointer;
		transition: all ease 0.5s 0s;
	}
	input[type=submit]:hover {
		border: 1px solid rgba(100, 100, 100, 0.3);
		color: rgba(100, 100, 100, 0.3);
		background-color: rgb(200, 255, 200);
		transition: all ease 0.5s 0s;
	}
</style>
</head>
<body>
<% if (session.getAttribute("mylogin") != null) {%>
<script type="text/javascript">
alert("이미 로그인 되어있음");
history.go(-1);
</script>
<%} %>
<a href="/"><button style="cursor: pointer;">Login</button></a>
<form action="/Login" method="post">
	<input type="text" name="id" placeholder="아이디를 입력하십시오" autocomplete="off"><br>
	<input type="password" name="pwd" placeholder="비밀번호를 입력하십시오"><br>
	<input type="submit" value="로그인">
</form>
<jsp:include page="/View/JspFooter.jsp"></jsp:include>
</body>
</html>