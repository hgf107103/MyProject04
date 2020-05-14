<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.UserModel.UserVO"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<script type="text/javascript">
	function logoutEvent() {
		let check = confirm("로그아웃 하시겠습니까?");
		if(check) {
			alert("로그아웃 되었습니다.");
			location.href="/Logout";
		} else {
			alert("로그아웃 취소되었습니다.");
		}
		
		
	}
</script>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gamja+Flower&display=swap" rel="stylesheet">
<style type="text/css">
	h1 {
		font-size: 45px;
		font-family: "Black Han Sans";
		font-weight: normal;
		color: black;
		transition: all ease 0.5s 0s;
	}
	h1:hover {
		cursor: default;
		color: gray;
		transition: all ease 0.5s 0s;
	}
	body {
		width: 400px;
		padding: 25px;
		margin: auto;
		text-align: center;
		border-right: 1px solid black;
		border-left: 1px solid black;
	}
	
	button {
		font-family: "Gamja Flower";
		width: 200px;
		font-weight: bold;
		border: 1px solid black;
		background: none;
		padding: 10px;
		margin: 10px;
		cursor: pointer;
		font-size: 23px;
		transition: all ease 0.5s 0s;
	}
	button:hover {
		background-color: black;
		color: white;
		transition: all ease 0.5s 0s;
	}
	section {
		padding-top: 30px;
		padding-bottom: 30px;
	}
	hr {
		margin-top: 15px;
		margin-bottom: 15px;
	}
</style>
</head>
<body>
  <h1>레스토랑 프로젝트</h1>
  <hr>
  <section>
 <%if(session.getAttribute("mylogin") == null) {%>
  <a href="/Login"><button>로그인</button></a><br>
  <a href="/SignUp"><button>회원가입</button></a>
  <%} else if(session.getAttribute("mylogin") != null) { %>
  <button onclick="logoutEvent()">로그아웃</button><br>
  		<%
  			UserVO nowLoginVO = (UserVO)session.getAttribute("mylogin");
  			if(nowLoginVO.getId().equals("admin")) {
  		%>
  		<a href="/Restaurant/Master"><button>레스토랑 : 마스터</button></a><br>
  		<%} %>
  <a href="/Restaurant"><button>레스토랑 : 게스트</button></a>
  <%} %>
  </section>
<jsp:include page="/View/JspFooter.jsp"></jsp:include>
</body>
</html>