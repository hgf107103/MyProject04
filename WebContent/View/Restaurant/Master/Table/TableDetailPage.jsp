<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마스터 : 테이블 상세보기</title>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gamja+Flower&display=swap" rel="stylesheet">
<style type="text/css">
	body{
		width: 650px;
		text-align: center;
	}
	h1 {
		width: 420px;
		cursor: default;
		margin: 20px auto;
		font-weight: normal;
		font-size: 40px;
		font-family: "Black Han Sans";
		transition: all ease 1s 0s;
	}
	h1:hover {
		color: rgb(50, 200, 150);
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
	table tr:hover > td.orderNumberTd {
		color: rgb(40,168,40);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.orderNameTd {
		color: rgb(255,100,100);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.orderCostTd {
		color: rgb(100, 100, 255);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.orderCountTd {
		color: rgb(168,40,168);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.orderDiscountTd {
		color: rgb(100,150,200);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.orderTotalTd {
		color: rgb(200,100,200);
		transition: all ease 0.5s 0s;
	}
	td a.updateOrder {
		cursor: pointer;
		font-family: "Gamja Flower";
		font-weight: bold;
		font-size: 20px;
		background: none;
		border: none;
		color: black;
		text-decoration: none;
		transition: all ease 1s 0s;
	}
	table tr:hover > td a.updateOrder {
		color: red;
		transition: all ease 0.5s 0s;
	}
	td a.updateOrder:hover {
		font-size: 23px;
		transition: all ease 0.5s 0s;
	}
	td a.updateOrder:visited {
		text-decoration: none;
	}
	#backButton {
		margin-top: 20px;
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
	div {
		margin-top: 150px;
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
</style>
</head>
<body>
<input id="backButton" type="button" onclick="history.go(-1)" value="뒤로가기">
<h1><span>${tableNumber}</span>번 테이블 주문 상세 내역</h1>
<table>
<c:if test="${not empty orderList}">
	<tr>
		<th>번호</th>
		<th>메뉴이름</th>
		<th>메뉴가격</th>
		<th>주문개수</th>
		<th>할인개수</th>
		<th>총 합계</th>
		<th>주문수정</th>
	</tr>
	<c:forEach items="${orderList}" var="order" varStatus="status">
		<tr>
    		<td class="orderNumberTd">
    			<c:out value="${status.index + 1}"></c:out>
    		</td>
    					
    		<td class="orderNameTd">
    			<c:out value="${order.orderName}"></c:out>
    		</td>
    					
    		<td class="orderCostTd">
    			<c:out value="${order.orderCost}원"></c:out>
    		</td>
    					
    		<td class="orderCountTd">
    			<c:out value="${order.orderCount}개"></c:out>
    		</td>
    		
    		<td class="orderDiscountTd">
    			<c:out value="${order.orderDiscount}개"></c:out>
    		</td>
    		
    		<td class="orderTotalTd">
    			<c:out value="${order.orderTotal}원"></c:out>
    		</td>
    					
    		<td class="updateOrderTd">	
    			<a class="updateOrder" href="#">주문수정</a>
    		</td>	
		</tr>
	</c:forEach>
</c:if>
	<c:if test="${orderList eq null}">
		<div>
			<h2>주문 내역이 없습니다!</h2>
		</div>
	</c:if>
</table>
</body>
</html>