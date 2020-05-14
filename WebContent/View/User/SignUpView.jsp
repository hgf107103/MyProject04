<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<script type="text/javascript" src="/View/User/JS/SignUpScript.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
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
	input[type=button] {
		font-size: 18px;
		width: 150px;
		padding: 10px;
		margin-top: 20px;
		margin-bottom: 20px;
		background: none;
		border: 1px solid black;
		cursor: pointer;
		transition: all ease 0.5s 0s;
	}
	input[type=button]:hover {
		color: white;
		background-color: black;
		transition: all ease 0.5s 0s;
	}
	input[type=button]:focus {
		outline: none;
	}
	form {
		margin-top: 50px;
		margin-bottom: 30px;
	}
	form span {
		display: inline-block;
		font-size: 20px;
		margin-top: 15px;
		margin-bottom: 5px;
	}
	fieldset {
		padding-top: 20px;
		padding-bottom: 40px;
		margin-bottom: 20px;
		border: 1px solid gray;
	}
	legend {
		width: 200px;
		font-size: 25px;
	}
</style>
</head>
<body>
<jsp:include page="/View/JspHeader.jsp"></jsp:include>
<form id="SignUpForm" name="SignUpForm" action="/SignUp" method="post">
	<fieldset>
	
		<legend>회원가입</legend>
		<input type="hidden" id="idcheck" value="false">
			<label><span>아이디</span><br>
			<input type="text" name="id" id="id" autocomplete="off">
			</label>
			<br>
			<input type="button" value="아이디 중복검사" onclick="SignUpIDCheckPopUp()">
			
			<br>
			
			<label><span>비밀번호</span><br>
			<input type="password" name="pwd" id="pwd">
			</label>
			
			<br>
			
			<label><span>이름</span><br>
			<input type="text" name="name" id="name" autocomplete="off">
			</label>
			
			<br>
			
			<label><span>성별</span><br>
			남자 <input type="radio" class="sex" name="sex" value="남자" checked="checked">
			여자 <input type="radio" class="sex" name="sex" value="여자">
			기타 <input type="radio" class="sex" name="sex" value="기타">
			</label>
			
	</fieldset>
	<input type="button" value="회원가입" onclick="SignUpCheak()">
</form>
<jsp:include page="/View/JspFooter.jsp"></jsp:include>
</body>
</html>