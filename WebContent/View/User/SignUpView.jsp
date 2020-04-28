<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
</head>
<body>
<form action="/SignUp" method="post">
	<fieldset>
	
		<legend>회원가입</legend>
			
			<label>아이디<br>
			<input type="text" name="id" id="id">
			</label>
			
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
			<input type="radio" name="sex" value="남자" checked="checked">
			<input type="radio" name="sex" value="여자">
			<input type="radio" name="sex" value="기타">
			</label>
			
	</fieldset>
	<input type="submit" value="회원가입">
</form>
</body>
</html>