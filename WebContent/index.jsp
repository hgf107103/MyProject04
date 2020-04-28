<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function logoutEvent() {
		alert("로그아웃 되었습니다.");
		
	}
</script>
</head>
<body>
  <h1>헬로</h1>
 <%if(session.getAttribute("mylogin") == null) {%>
  <a href="/Login"><button>로그인 페이지로 이동</button></a><br>
  <a href="/SignUp"><button>회원가입 페이지로 이동</button></a>
  <%} else if(session.getAttribute("mylogin") != null) { %>
  <a href="/Logout"><button onclick="logoutEvent()">로그아웃 페이지로 이동</button></a>
  <%} %>
</body>
</html>