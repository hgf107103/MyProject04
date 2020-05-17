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
	input[type=button] {
		margin-top: 10px;
		cursor: pointer;
		font-size: 40px;
		font-family: "Black Han Sans";
		color: rgb(50, 200, 150);
		background: none;
		border: none;
		padding: 10px;
		transition: all ease 1s 0s;
	}
	input[type=button]:hover {
		color: rgb(255, 200, 200);
		transition: all ease 1s 0s;
	}
	input[type=button]:focus {
		outline: none;
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
		font-family: "Gamja Flower";
		font-size: 23px;
		text-decoration: none;
		outline: none;
		border: 1px solid gray;
		transition: all ease 0.5s 0s;
	}
	input[type=text]:focus {
		text-decoration: none;
		border-radius: 25px;
		border: 1px solid rgb(50, 200, 150);
		box-shadow: 0 0 0 5px rgba(50, 200, 150, 0.2);
		transition: all ease 0.5s 0s;
	}
	input[type=text]:hover {
		text-decoration: none;
		border-radius: 25px;
		transition: all ease 0.5s 0s;
	}
	input[type=password] {
		margin: 10px auto;
		width: 250px;
		padding: 10px 0px;
		font-family: "Gamja Flower";
		font-size: 23px;
		text-decoration: none;
		outline: none;
		border: 1px solid gray;
		transition: all ease 0.5s 0s;
	}
	input[type=password]:focus {
		text-decoration: none;
		border-radius: 25px;
		border: 1px solid rgb(50, 200, 150);
		box-shadow: 0 0 0 5px rgba(50, 200, 150, 0.2);
		transition: all ease 0.5s 0s;
	}
	input[type=password]:hover {
		text-decoration: none;
		border-radius: 25px;
		transition: all ease 0.5s 0s;
	}
	#loginButton {
		font-family: "Gamja Flower";
		font-size: 23px;
		font-weight: bold;
		width: 50px;
		padding: 10px;
		margin-top: 30px;
		background: none;
		border: 1px solid rgb(50,200,150);
		color: white;
		cursor: pointer;
		border-radius: 25px;
		transition: all ease 1s 0s;
	}
	#loginButton:hover {
		border-radius: 25px;
		width: 150px;
		color: rgb(50,200,150);
		border: 1px solid rgb(50,200,150);
		background-color: white;
		box-shadow: 0 0 0 4px rgba(50, 200, 150, 0.25);
		transition: all ease 1s 0s;
	}
	#loginButton:focus {
		outline: none;
	}
</style>
<script type="text/javascript">
	function overIndex() {
		console.log("Index Mouse On");
		document.getElementById("indexbutton").value = 'Index';
	}
	function outIndex() {
		console.log("Index Mouse Out");
		document.getElementById("indexbutton").value = 'Login';
	}
	function loginSubmit() {
		try {
			let form = document.getElementById("loginForm");
			let id = document.getElementById("id").value;
			let pass = document.getElementById("pwd").value;
			if (id != '') {
				console.log("loginSubmit_LOG : Id Value " + id);
				
				if (pass != '') {
					console.log("loginSubmit_LOG : Pass Value " + id);
					form.submit();
				} else {
					console.log("loginSubmit_NOT : Not Pass Value ");
					alert("비밀번호를 입력하십시오");
					return false;
				}
			} else {
				console.log("loginSubmit_NOT : Not Id Value ");
				alert("아이디를 입력하십시오");
				return false;
			}
		} catch (e) {
			console.log("loginSubmit_ERROR : ERROR " + e);
			alert("로그인 오류가 발생했습니다.");
			return false;
		}
		
	}
</script>
</head>
<body>
<% if (session.getAttribute("mylogin") != null) {%>
<script type="text/javascript">
alert("이미 로그인 되어있음");
history.go(-1);
</script>
<%} %>
<a href="/"><input type="button" value="Login" onmouseenter="overIndex()" onmouseout="outIndex()" id="indexbutton"></a>
<form action="/Login" id="loginForm" method="post">
	<input type="text" id="id" name="id" placeholder="아이디를 입력하십시오" autocomplete="off"><br>
	<input type="password" id="pwd" name="pwd" placeholder="비밀번호를 입력하십시오"><br>
	<input id="loginButton" onclick="loginSubmit()" type="button" value="로그인">
</form>
<jsp:include page="/View/JspFooter.jsp"></jsp:include>
</body>
</html>