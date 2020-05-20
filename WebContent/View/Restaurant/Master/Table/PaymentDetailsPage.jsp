<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마스터 : 결제 상세 내역</title>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gamja+Flower&display=swap" rel="stylesheet">
<style type="text/css">
	body {
		text-align: right;
		width: 700px;
	}
	h1 {
		margin: auto;
		text-align: center;
		cursor: default;
		margin: 20px auto;
	}
	h1 span {
		font-weight: normal;
		font-size: 40px;
		font-family: "Black Han Sans";
		transition: all ease 1.5s 0s;
	}
	span.headTitle:hover {
		color: rgb(20, 170, 120);
		transition: all ease 2s 0s;
	}
	span.payNumber:hover {
		color: rgb(100,100,100);
		transition: all ease 1s 0s;
	}
	
	h3 {
		cursor: default;
		width: 400px;
		border-radius: 30px;
		margin: auto;
		margin-bottom: 30px;
		font-family: "Gamja Flower";
		text-align: center;
		font-size: 30px;
		background-color: black;
		color: white;
		padding: 10px;
		transition: all ease 1s 0s;
	}
	h3 span {
		color: black;
		transition: all ease 3s 0s;
	}
	h3:hover {
		box-shadow: 0 0 0 5px rgba(100,100,100, 0.4);
		transition: all ease 1s 0s;
	}
	h3:hover > span {
		color: white;
		transition: all ease 1s 0s;
	}
	table {
		width: 100%;
		margin: auto;
		border-collapse: collapse;
	}
	
	table th {
		text-align: center;
		background-color: black;
		color: white;
		padding: 10px;
		font-size: 23px;
		font-weight: normal;
		border-right: 1px solid white;
		border-left: 1px solid black;
		transition: all ease 1s 0s;
		font-family: "Black Han Sans";
		cursor: default;
	}
	table th:hover {
		color: black;
		background-color: white;
		border-left: 1px solid white;
		transition: all ease 1s 0s;
	}
	table td {
		font-family: "Gamja Flower";
		font-size: 23px;
		text-align: center;
		font-weight: bold;
		padding: 10px;
		cursor: default;
		color: rgb(150,150,150);
		border-bottom: 1px solid black;
		border-collapse: collapse;
		transition: all ease 1.5s 0s;
	}
	table tr:hover > td.menuNameTd {
		color: rgb(40,168,40);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.menuCostTd {
		color: rgb(255,100,100);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.orderCountTd {
		color: rgb(100, 100, 255);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.orderDiscountTd {
		color: rgb(168,40,168);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.payTotalTd {
		color: rgb(100,150,200);
		transition: all ease 0.5s 0s;
	}
	div {
		margin-top: 150px;
		text-align: center;
	}
	div h2{
		cursor:default;
		font-size: 35px;
		font-family: "Gamja Flower";
		transition: all ease 1s 0s;
	}
	div h2:hover {
		color: red;
		transition: all ease 0.5s 0s;
	}
	#backButton {
		display: inline-block;
		margin-top: 20px;
		margin: auto;
		padding: 5px 20px;
		background-color: white;
		font-size: 23px;
		font-weight: bold;
		cursor: pointer;
		border-radius: 25px;
		font-family: "Gamja Flower";
		color: white;
		border: 1px solid rgb(50,200,150);
		transition: all ease 1.5s 0s;
	}
	#backButton:hover {
		color: black;
		box-shadow: 0 0 0 5px rgba(50, 200, 150, 0.25);
		transition: all ease 1s 0s;
	}
	#backButton:focus {
		outline: none;
	}
</style>
</head>
<body>
<input id="backButton" type="button" onclick="history.go(-1)" value="뒤로가기">
<h1><span class="payNumber"><c:out value="${payHistory.customersName}"></c:out>고객님</span><br><span class="headTitle">결제번호</span> <span class="payNumber"><c:out value="${payHistory.payNumber}"></c:out></span></h1>
<h3>총 합계 금액 : <span><c:out value="${payHistory.payTotal}"></c:out></span> 원</h3>
<c:if test="${not empty payDetailList}">
<table>
	<tr>
		<th>메뉴이름</th>
		<th>가격(1개)</th>
		<th>주문개수</th>
		<th>할인개수</th>
		<th>주문 가격 합계</th>
	</tr>
	<c:forEach items="${payDetailList}" var="pay" varStatus="status">
			<tr>		
    			<td class="menuNameTd">
    				<c:out value="${pay.menuName}"></c:out>
    			</td>
    					
    			<td class="menuCostTd">
    				<c:out value="${pay.menuCost}원"></c:out>
    			</td>
    					
    			<td class="orderCountTd">
    				<c:out value="${pay.orderCount}개"></c:out>
    			</td>
    		
    			<td class="orderDiscountTd">
    				<c:out value="${pay.orderDiscount}개"></c:out>
    			</td>
    			
    			<td class="payTotalTd">
    				<c:out value="${pay.orderTotal}개"></c:out>
    			</td>
			</tr>
	</c:forEach>
</table>
</c:if>
	<c:if test="${empty payDetailList}">
		<div>
			<h2>결재 내역이 없습니다!</h2>
		</div>
	</c:if>
	
</body>
</html>