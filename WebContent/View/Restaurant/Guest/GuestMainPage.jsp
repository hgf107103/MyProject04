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
	function outTableScript() {
		try {
			let form = document.getElementById("tableOutForm");
			let check = confirm("퇴실하시겠습니까?");
			
			if (check) {
				form.submit();
			} else {
				alert("퇴실 취소되었습니다.");
			}
		} catch (e) {
			console.log("SelectDisableTable_ERROR : " + e);
		}
	}
	function paymentScript(tableNumber, pageNumber) {
		try {
			let check = confirm("주문내역을 확인하시겠습니까?");
			
			if (check) {
				
				let url = "/Restaurant/Guest/Payment?pageNumber="+pageNumber+"&tableNumber="+tableNumber;
			    let name = "Order Show";
			    let option = "width = 650, height = 550, top = 100, left = 200, location = no, scrollbars = yes, re";
			    window.open(url, name, option);
			    
			} else {
				alert("취소되었습니다.");
			}
		} catch (e) {
			console.log("SelectDisableTable_ERROR : " + e);
		}
	}
	
	function newOrderScript() {
		try {
			let check = confirm("새 주문을 하시겠습니까?");
			
			if (check) {
				
				let url = "/Restaurant/Guest/Order?pageNumber=1";
			    let name = "Order Show";
			    let option = "width = 550, height = 550, top = 100, left = 200, location = no, scrollbars = yes, re";
			    window.open(url, name, option);
			    
			} else {
				alert("취소되었습니다.");
			}
		} catch (e) {
			console.log("SelectDisableTable_ERROR : " + e);
		}
	}
	
</script>
</head>
<body>
<jsp:include page="/View/JspHeader.jsp"></jsp:include>

<div>
	<h1>테이블 번호 : ${nowTable.tableNumber}<br>${nowLoginVO.name} 고객님</h1>
	<button onclick="newOrderScript()">메뉴 주문</button>
	<br>
	<button onclick="paymentScript('${nowTable.tableNumber}', '1')">내역/결제</button>
	<br>
	<form action="/Restaurant/Guest/OutTable" method="post" id="tableOutForm" style="display: none;">
		<input type="hidden" name="tableNumber" value="${nowTable.tableNumber}">
	</form>
	
	<button onclick="outTableScript()">퇴실</button>
</div>
<jsp:include page="/View/JspFooter.jsp"></jsp:include>

</body>
</html>