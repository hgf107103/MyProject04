<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레스토랑 : 게스트</title>
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
	div {
		padding-top: 30px;
		padding-bottom: 30px;
		font-weight: normal;
		cursor: default;
	}
	h1 {
		font-family: "Black Han Sans";
		margin-bottom: 60px;
		font-size: 40px;
		font-weight: normal;
		color: rgb(0, 0, 0);
		transition: all ease 0.5s 0s;
	}
	h1:hover {
		color: rgb(150, 150, 150);
		transition: all ease 0.5s 0s;
	}
	button {
		margin-top: 10px;
		font-size: 40px;
		font-family: "Gamja Flower";
		font-weight: bold;
		color: rgb(200, 200, 200);
		background: none;
		border: 1px solid rgb(255, 255, 255);
		padding: 10px;
		transition: all ease 0.5s 0s;
		cursor: pointer;
	}
	button:hover {
		color: rgb(0, 0, 0);
		border: 1px solid rgba(180, 180, 180, 0.3);
		box-shadow: 0 0 0 3px rgba(180, 180, 180, 0.3);
		transition: all ease 0.5s 0s;
	}
	button:focus {
		outline: none;
	}
</style>
<script type="text/javascript">
	function exitGuest() {
		let check = confirm("퇴장 하시겠습니까?");
		
		if(check) {
			let checkTwo = confirm("로그아웃 하시겠습니까?");
			
			if (checkTwo) {
				alert("로그아웃 되었습니다.");
				location.href="/Logout";
			} else {
				alert("메인화면으로 돌아갑니다.");
				location.href="/";
			}
			
		} else {
			alert("퇴장을 취소합니다.");
			return false;
		}
	}
</script>
<script type="text/javascript" src="/View/Restaurant/Guest/JS/GuestPopUpControllScript.js"></script>
</head>
<body>
<jsp:include page="/View/JspHeader.jsp"></jsp:include>

<div>
	<h1>${nowLoginVO.id}<br>${nowLoginVO.name} 고객님<br>현재 선택된 자리 없음</h1>
	<button onclick="EnableTableShowPopUp('${nowLoginVO.name}')">자리 선택</button>
	<button onclick="exitGuest()">퇴장</button>
</div>

<jsp:include page="/View/JspFooter.jsp"></jsp:include>

</body>
</html>