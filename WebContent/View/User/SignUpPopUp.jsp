<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID Cheak</title>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gamja+Flower&display=swap" rel="stylesheet">
<style type="text/css">

	body {
		text-align: center;
	}
	h1 {
		padding-top: 15px;
		font-family: "Black Han Sans";
		font-weight: normal;
		cursor: default;
		transition: all ease 0.5s 0s;
	}
	h1:hover {
		color: rgb(50, 200, 150);
		transition: all ease 0.5s 0s;
	}
	div {
		padding-top: 50px;
		text-align: center;
		font-size: 30px;
		font-family: "Gamja Flower";
		cursor: default;
	}
	div p{
		transition: all ease 0.5s 0s;
	}
	div p:hover {
		color: red;
		transition: all ease 0.5s 0s;
	}
	button {
		font-size: 17px;
		width: 150px;
		padding: 10px;
		margin-top: 30px;
		background: none;
		border: 1px solid black;
		cursor: pointer;
		transition: all ease 0.5s 0s;
	}
	button:hover {
		color: white;
		background-color: black;
		transition: all ease 0.5s 0s;
	}
	form {
		padding-bottom: 10px;
	}
	input[type=text] {
		margin: 10px auto;
		width: 200px;
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
	input[type=button] {
		font-size: 17px;
		padding: 2px;
		width: 200px;
		margin-bottom: 10px;
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
</style>
</head>
<body oncontextmenu='return false'>
<h1>아이디 중복 검사</h1>
<script>
	function idCheak() {
		try {
			
			let form = document.getElementById("idCheckForm"); 
			let id = document.getElementById("popId").value;
			let idReg = new RegExp('(?!^[0-9]*$)(?!^[a-zA-Z]*$)^([a-zA-Z0-9]{6,20})$', 'gm');
			
			if (id != '') {
				if (idReg.test(id)) {
					console.log("SignUpIDRegExp_log : ID " + id);
					form.submit();
				} else {
					console.log("SignUpIDRegExp_not : this ID did not pass the RegExp : " + id);
					alert("아이디는 영문과 숫자로만 만들 수 있습니다.\n길이는 6자리 이상 20자리 이하여야 합니다.");
					return false;
				}
			} else {
				console.log("SignUpIDRegExp_not : Not Found id value");
				alert("아이디를 입력해 주십시오.");
				return false;
			}
			
		} catch (e) {
			console.log("SignUpIDRegExp_error : " + e);
			return false;
		}
	}
</script>
<form action="/IdCheak" method="post" id="idCheckForm">
	<input type="text" id="popId" name="popId"  value="<%= request.getParameter("id") %>"><br>
	<input type="button" id="popCheakId" onclick="idCheak()" value="확인">
</form>
<hr>
<%if (request.getParameter("isIdCheakd") != null) {%>
<div>
	<%if (request.getParameter("isIdCheakd").equals("cheakok")) {%>
	
	<p><%= request.getParameter("id")%>는 중복된 아이디가 아닙니다.</p>
	<input type="hidden" id="checkedid" value="<%= request.getParameter("id")%>">
	<script type="text/javascript">
	function pickId() {
		window.opener.document.getElementById("id").value = document.getElementById("checkedid").value;
		window.opener.document.getElementById("idcheck").value = "true"
		self.close();
	}
	</script>
	
	<button onclick="pickId()">확인</button>
	
	<%} else {%>
	<p><%= request.getParameter("id")%>는 중복되는 아이디입니다.</p>
	<%} %>
</div>
<%} else {}%>
</body>
</html>