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
		font-family: "Gamja Flower";
		text-align: center;
		margin: 10px auto;
		width: 250px;
		padding: 10px 0px;
		font-size: 23px;
		text-decoration: none;
		outline: none;
		border: 1px solid gray;
		transition: all ease 0.5s 0s;
	}
	input[type=text]:focus {
		border-radius: 25px;
		text-decoration: none;
		box-shadow: 0 0 0 5px rgba(180, 180, 180, 0.3);
		transition: all ease 0.5s 0s;
	}
	input[type=password] {
		font-family: "Gamja Flower";
		text-align: center;
		margin: 10px auto;
		width: 250px;
		padding: 10px 0px;
		font-size: 23px;
		text-decoration: none;
		outline: none;
		border: 1px solid gray;
		transition: all ease 0.5s 0s;
	}
	input[type=password]:focus {
		border-radius: 25px;
		text-decoration: none;
		box-shadow: 0 0 0 5px rgba(180, 180, 180, 0.3);
		transition: all ease 0.5s 0s;
	}
	input[type=button] {
		font-family: "Gamja Flower";
		font-size: 23px;
		width: 200px;
		padding: 10px;
		margin-top: 20px;
		margin-bottom: 50px;
		background: none;
		border: 1px solid black;
		cursor: pointer;
		transition: all ease 0.5s 0s;
	}
	input[type=button]:hover {
		border-radius: 25px;
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
	form #sexRadio {
		display: inline-block;
		font-family: "Black Han Sans";
		font-size: 25px;
		margin-top: 30px;
		margin-bottom: 5px;
		transition: all ease 0.5s 0s;
	}
	form #sexRadio:hover {
		color: rgb(50, 200, 150);
		transition: all ease 0.5s 0s;
	}
	fieldset {
		padding-top: 30px;
		padding-bottom: 50px;
		margin-bottom: 20px;
		border: 1px solid gray;
	}
	legend {
		font-family: "Black Han Sans";
		width: 200px;
		font-size: 40px;
		transition: all ease 0.5s 0s;
	}
	legend:hover {
		color: rgb(50, 200, 150);
		transition: all ease 0.5s 0s;
	}
	input[type=radio] {
		display: none;
	}
	.sexText {
		font-weight: bold;
		font-size: 25px;
		font-family: "Gamja Flower";
		padding: 0px 10px;
		color: rgb(245,245,245);
		transition: all ease 1.5s 0s;
	}
	.sexText:hover {
		color: rgb(0,0,0);
		transition: all ease 0.5s 0s;
	}
	input[type=radio]:checked + .sexText {
		color: red;
		transition: all ease 0.5s 0s;
	}
	.signupText {
		margin-top: 20px;
		font-family: "Black Han Sans";
		font-size: 25px;
		transition: all ease 0.5s 0s;
	}
	#pwd {
		margin-bottom: 50px;
	}
	#name {
		margin-bottom: 30px;
	}
	.signupText:hover {
		color: rgb(50, 200, 150);
		transition: all ease 0.5s 0s;
	}
</style>
</head>
<body>
<jsp:include page="/View/JspHeader.jsp"></jsp:include>
<form id="SignUpForm" name="SignUpForm" action="/SignUp" method="post">
	<fieldset>
	
		<legend>회원가입</legend>
			<input type="hidden" id="idcheck" value="false">
			<label><span class="signupText">아이디</span><br>
			<input type="text" name="id" id="id" autocomplete="off" placeholder="아이디를 입력하세요">
			</label>
			<br>
			<input type="button" value="아이디 중복검사" onclick="SignUpIDCheckPopUp()">
			
			<br>
			
			<label><span class="signupText">비밀번호</span><br>
			<input type="password" name="pwd" id="pwd" placeholder="비밀번호를 입력하세요">
			</label>
			
			<br>
			
			<label><span class="signupText">이름</span><br>
			<input type="text" name="name" id="name" autocomplete="off" placeholder="이름을 입력하세요">
			</label>
			
			<br>
			
			<span id="sexRadio">성별</span><br>
			<label><input type="radio" class="sex" name="sex" value="남자" checked="checked"><span class="sexText">남자</span></label>
			<label><input type="radio" class="sex" name="sex" value="여자"><span class="sexText">여자</span></label>
			<label><input type="radio" class="sex" name="sex" value="기타"><span class="sexText">기타</span></label>
			
	</fieldset>
	<input type="button" value="회원가입" onclick="SignUpCheak()">
</form>
<jsp:include page="/View/JspFooter.jsp"></jsp:include>
</body>
</html>