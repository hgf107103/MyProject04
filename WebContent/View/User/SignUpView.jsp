<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<script type="text/javascript" src="/View/User/JS/SignUpScript.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>

<form id="SignUpForm" name="SignUpForm" action="/SignUp" method="post">
	<fieldset>
	
		<legend>회원가입</legend>
		
			<label>아이디<br>
			<input type="text" name="id" id="id">
			</label>
			<br>
			<input type="button" value="아이디 중복검사" onclick="SignUpIDCheakPopUp()">
			
			<br>
			
			<label>비밀번호<br>
			<input type="password" name="pwd" id="pwd">
			</label>
			
			<br>
			
			<label>이름<br>
			<input type="text" name="name" id="name">
			</label>
			
			<br>
			
			<label>성별<br>
			남자 <input type="radio" class="sex" name="sex" value="남자" checked="checked">
			여자 <input type="radio" class="sex" name="sex" value="여자">
			기타 <input type="radio" class="sex" name="sex" value="기타">
			</label>
			
	</fieldset>
	<input type="button" value="회원가입" onclick="SignUpCheak()">
</form>
</body>
</html>