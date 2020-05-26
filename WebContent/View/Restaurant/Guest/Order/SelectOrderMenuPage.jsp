<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게스트 : ${categoryName}</title>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gamja+Flower&display=swap" rel="stylesheet">
<style type="text/css">
	body {
		width: 535px;
		text-align: center;
	}
	h1 {
		margin: 10px auto;
		text-align: center;
		font-size: 45px;
		font-weight: normal;
		font-family: "Black Han Sans";
		cursor: default;
		transition: all ease 1s 0s;
	}
	h1:hover {
		color: rgb(20, 170, 120);
		transition: all ease 1s 0s;
	}
	*:focus {
		outline: none;
	}
	input {
		text-align: center;
	}
	label {
		font-family: "Black Han Sans";
		font-size: 25px;
		transition: all ease 0.5s 0s;
	}
	label:hover {
		color: rgb(20,170,120);
		transition: all ease 0.5s 0s;
	}
	select {
		border-radius: 0px;
		width: 50%;
		padding: 5px;
		cursor: pointer;
		text-align: right;
		font-family: "Gamja Flower";
		font-size: 23px;
		font-weight: bold;
		border: 1px solid black;
		background-color: white;
		color: black;
		transition: all ease 1s 0s;
		margin: 0px 0px;
	}
	select:hover {
		border-radius: 25px;
		transition: all ease 1s 0s;
	}
	select:focus {
		outline: none;
		border-radius: 25px;
		border: 1px solid rgb(50,200,150);
		box-shadow: 0 0 0 5px rgba(50, 200, 150, 0.2);
		transition: all ease 1s 0s;
	}
	option {
		font-family: "Gamja Flower";
		font-size: 20px;
		font-weight: bold;
		background-color: white;
		color: black;
		transition: all ease 0.5s 0s;
	}
	option:checked {
		color: red;
		transition: all ease 0.5s 0s;
	}
	input[type=text] {
		font-family: "Gamja Flower";
		margin: auto;
		margin-bottom: 15px;
		width: 200px;
		padding: 5px 0px;
		font-size: 21px;
		font-weight: bold;
		text-decoration: none;
		outline: none;
		border: 1px solid gray;
		transition: all ease 0.5s 0s;
	}
	input[type=text]:focus {
		text-decoration: none;
		border-radius: 25px;
		color: red;
		border: 1px solid red;
		box-shadow: 0 0 0 5px rgba(255,0,0, 0.2);
		transition: all ease 0.5s 0s;
	}
	input[type=text]:hover {
		text-decoration: none;
		border-radius: 25px;
		transition: all ease 0.5s 0s;
	}
	input[type=number] {
		font-family: "Gamja Flower";
		margin: auto;
		width: 60px;
		padding: 5px 0px;
		font-size: 20px;
		text-decoration: none;
		outline: none;
		border: 1px solid gray;
		transition: all ease 0.5s 0s;
	}
	input[type=number]:focus {
		text-decoration: none;
		border-radius: 25px;
		border: 1px solid rgb(50, 200, 150);
		box-shadow: 0 0 0 5px rgba(50, 200, 150, 0.2);
		transition: all ease 0.5s 0s;
	}
	input[type=number]:hover {
		text-decoration: none;
		border-radius: 25px;
		transition: all ease 0.5s 0s;
	}
	input[type=button].submitButton {
		cursor: pointer;
		border: 1px solid black;
		background-color: white;
		width: 150px;
		font-size: 23px;
		margin: auto;
		margin-right: 20px;
		padding: 8px 0px;
		padding-top: 10px;
		font-family: "Gamja Flower";
		font-weight: bold;
		transition: all ease 0.5s 0s;
	}
	input[type=button].submitButton:hover{
		color: white;
		background-color: black;
		border-radius: 25px;
		transition: all ease 0.5s 0s;
	}
	input[type=button].submitButton:focus {
		outline: none;
	}
</style>
<script type="text/javascript">
	function menuDetailsSet() {
		let select = document.getElementById("menuSelect").selectedIndex;
		let options = document.getElementById("menuSelect").options[select].value;
		let check = true;
		
		let nameList = new Array();
		let costList = new Array();
		let orderNameList = new Array();
		let orderCountList = new Array();
		let orderDiscountList = new Array();
		
		<c:forEach items="${menuList}" var="menu">
			nameList.push("${menu.menuName}");
			costList.push("${menu.menuCost}");
		</c:forEach>
		
		<c:forEach items="${orderList}" var="order">
			orderNameList.push("${order.orderName}");
			orderCountList.push("${order.orderCount}");
			orderDiscountList.push("${order.orderDiscount}");
		</c:forEach>
		
		console.log("선택한 메뉴 이름 : " + nameList[select]);
		console.log("선택한 메뉴 가격 : " + costList[select]);
		
		document.getElementById("menuNameText").value = nameList[select];
		document.getElementById("menuCostText").value = costList[select] + "원";
		document.getElementById("newOrderCount").value = 0;
		
		
		orderNameList.forEach(function(elt, i, array) {
			if (elt == nameList[select]) {
				console.log(i + " : " + elt + " == " + nameList[select]);
				console.log(elt + " : " + (Number(orderCountList[i]) - Number(orderDiscountList[i])));
				document.getElementById("menuCountText").value = Number(orderCountList[i]) - Number(orderDiscountList[i]) + "개";
				check = false;
			}
		});
		
		console.log("체크 : " + check);
		
		if (check) {
			document.getElementById("menuCountText").value = "0개";
		}
	}
</script>
</head>
<body>

<input type="button" value="뒤로가기" onclick="history.go(-1)">
<h1>${categoryName}메뉴 보기</h1>
<select id="menuSelect" onchange="menuDetailsSet()">
	<c:forEach items="${menuList}" var="menu">
		<option>${menu.menuName}</option>
	</c:forEach>
</select>
<br>
<br>
<form action="" method="get">
	<label>선택한 메뉴 이름<br><input type="text" id="menuNameText" readonly="readonly" value="${menuList[0].menuName}"></label><br>
	<label>선택한 메뉴 가격<br><input type="text" id="menuCostText" readonly="readonly" value="${menuList[0].menuCost}원"></label><br>
	<label>현재 주문된 개수<br><input type="text" id="menuCountText" readonly="readonly" value="${orderList[0].orderCount - orderList[0].orderDiscount}개"></label><br>
	<br>
	<label>추가 주문 개수 (최대 50)<br><input type="number" id="newOrderCount" step="1" min="0" max="50" value="0">개</label><br>
	<br>
	<input type="button" class="submitButton" value="주문하기">
</form>
</body>
</html>