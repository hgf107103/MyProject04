<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogIn</title>
</head>
<body>
<h1>로그인 페이지 입니다.</h1>
<% if (session.getAttribute("mylogin") != null) {%>
<script type="text/javascript">
alert("이미 로그인 되어있음");
history.go(-1);
</script>
<%} %>
<form action="/Login" method="post">
	<input type="text" name="id" placeholder="아이디를 입력하십시오" autocomplete="off"><br>
	<input type="password" name="pwd" placeholder="비밀번호를 입력하십시오"><br>
	<input type="submit" value="로그인">
</form>
</body>
</html>