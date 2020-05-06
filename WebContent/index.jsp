<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.UserVO"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
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
  <a href="/Logout"><button onclick="logoutEvent()">로그아웃</button></a><br>
  		<%
  			UserVO nowLoginVO = (UserVO)session.getAttribute("mylogin");
  			if(nowLoginVO.getId().equals("admin")) {
  		%>
  		<a href="/Restaurant?isMaster=true"><button>레스토랑 : 마스터</button></a><br>
  		<%} %>
  <a href="/Restaurant?isMaster=false"><button>레스토랑 : 게스트</button></a>
  <%} %>
</body>
</html>