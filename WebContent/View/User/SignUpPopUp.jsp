<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID Cheak</title>
</head>
<body oncontextmenu='return false'>
<h1>아이디 중복 검사</h1>
<form action="/IdCheak" method="post">
	<input type="text" id="popId" name="popId"  value="<%= request.getParameter("id") %>">
	<input type="submit" id="popCheakId" value="확인">
</form>
<%if (request.getParameter("isIdCheakd") != null) {%>
<div>
	<%if (request.getParameter("isIdCheakd").equals("cheakok")) {%>
	
	<p><%= request.getParameter("id")%>는 사용가능한 아이디 입니다.</p>
	
	<script type="text/javascript">
	function pickId() {
		window.opener.document.getElementById("id").value = document.getElementById("popId").value;
		window.opener.document.getElementById("idcheak").value = "true"
		self.close();
	}
	</script>
	
	<button onclick="pickId()">확인</button>
	
	<%} else {%>
	<p><%= request.getParameter("id")%>는 사용할 수 없는 아이디 입니다.</p>
	<%} %>
</div>
<%} else {}%>
</body>
</html>