<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게스트 : 결제</title>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gamja+Flower&display=swap" rel="stylesheet">
<style type="text/css">
	body {
		width: 625px;
	}
	h1 {
		font-family: "Black Han Sans";
		margin: 40px auto;
		text-align: center;
		font-size: 40px;
		font-weight: normal;
		cursor: default;
		color: rgb(0, 0, 0);
		transition: all ease 0.5s 0s;
	}
	h1:hover {
		color: rgb(50, 200, 150);
		transition: all ease 0.5s 0s;
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
		color: rgb(30,180,130);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.orderNameTd {
		color: rgb(40,155,180);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.orderCostTd {
		color: rgb(255,100,100);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.orderDiscostTd {
		color: rgb(100, 100, 255);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.orderTotalTd {
		color: rgb(168,40,168);
		transition: all ease 0.5s 0s;
	}
	td a {
		cursor: pointer;
		font-family: "Gamja Flower";
		font-weight: bold;
		font-size: 23px;
		background: none;
		border: none;
		color: black;
		text-decoration: none;
		transition: all ease 1s 0s;
	}
	td a:hover {
		color: red;
		transition: all ease 0.5s 0s;
	}
	td a:visited {
		text-decoration: none;
	}
	div {
		padding-top: 20px;
		padding-bottom: 20px;
		text-align: center;
		cursor: default;
		font-family: "Black Han Sans";
		font-size: 23px;
	}
	div span {
		font-weight: bold;
	}
	div a{
		text-decoration: none;
		color: black;
		transition: all ease 0.5s 0s;
	}
	div a:hover {
		color: rgb(20, 170, 120);
		transition: all ease 0.5s 0s;
	}
	div a:visited {
		text-decoration: none;
	}
	h2 {
		text-align: center;
		cursor: default;
		font-size: 35px;
		font-family: "Black Han Sans";
		font-weight: normal;
		transition: all ease 0.5s 0s;
	}
	h2:hover {
		color: rgb(80,80,80);
		transition: all ease 0.5s 0s;
	}
	section{
		text-align: center;
	}
	button {
		padding: 8px 20px;
		border: 1px solid black;
		background-color: white;
		font-family: "Gamja Flower";
		font-weight: bold;
		font-size: 23px;
		cursor: pointer;
		transition: all ease 1s 0s;
	}
	button:hover {
		border: 1px solid rgb(50,200,150);
		border-radius: 25px;
		box-shadow: 0 0 0 5px rgba(50, 200, 150, 0.2);
		transition: all ease 1s 0s;
	}
	button:focus {
		outline: none;
	}
	h3 {
		margin: auto;
		margin-top: 20px;
		font-family: "Gamja Flower";
		font-size: 30px;
		text-align: center;
	}
</style>
<script type="text/javascript">
	function completePayment() {
		let form = document.getElementById("CompletePaymentForm");
		let check = confirm("전체 내역 결제 하시겠습니까?");
		
		if (check) {
			console.log("CompletePayment_LOG : confirm payment");
			form.submit();
		} else {
			console.log("CompletePayment_LOG : denai payment");
			alert("결제 취소되었습니다.");
		}
		
	}
</script>
</head>
<body>
<h1>${tableNumber}번 테이블 주문내역</h1>
<c:if test="${orderList ne null}">
<table>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>가격</th>
		<th>할인</th>
		<th>도합</th>
	</tr>
	<c:set var="allTotal" value="0"></c:set>
	<c:forEach items="${orderList}" var="order" varStatus="status" begin="${((pageNumber - 1) * 4)}" end="${((pageNumber - 1) * 4) + 3}">
	<tr>
		<td class="orderNumberTd"><c:out value="${status.count * pageNumber}"></c:out></td>
		<td class="orderNameTd"><c:out value="${order.orderName}"></c:out></td>
		<td class="orderCostTd"><c:out value="${order.orderCount * order.orderCost}원"></c:out></td>
		<td class="orderDiscostTd"><c:out value="-${order.orderDiscount * order.orderCost}원"></c:out></td>
		<td class="orderTotalTd"><c:out value="${(order.orderCount - order.orderDiscount) * order.orderCost}원"></c:out></td>
		
		<c:set var="allTotal" value="${allTotal + (order.orderCount - order.orderDiscount) * order.orderCost}"></c:set>
	</tr>
	</c:forEach>
</table>
<h3>전체 합계 금액 : <c:out value="${allTotal}"></c:out></h3>
<div>
	<c:if test="${pageNumber > 1}">
		<a href="/Restaurant/Guest/Payment?pageNumber=${pageNumber - 1}&tableNumber${tableNumber}">뒤로</a>
	</c:if>
	<c:if test="${pageNumber > 0}">
	<c:forEach var="num" begin="${pageNumber - ((pageNumber - 1) % 5)}" end="${(pageNumber - ((pageNumber - 1) % 5)) + 4}" varStatus="now">
		<c:if test="${num <= (fn:length(orderList) / 5)+(1-((fn:length(orderList) / 5)%1))%1}">
			
			
			<c:if test="${num == pageNumber}">
				<span style="color: red;">${num}</span>
			</c:if>
			
			<c:if test="${num != pageNumber}">
				<a href="/Restaurant/Guest/Payment?pageNumber=${num}&tableNumber${tableNumber}">${num}</a>
			</c:if>
			
		</c:if>
	</c:forEach>
	</c:if>
	<c:if test="${pageNumber < (fn:length(orderList) / 5)+(1-((fn:length(orderList) / 5)%1))%1}">
				<a href="/Restaurant/Guest/Payment?pageNumber=${pageNumber + 1}&tableNumber${tableNumber}">앞으로</a>
	</c:if>
	<c:if test="${empty orderList}">
	<h2>주문 내역이 없습니다!</h2>
</c:if>
</div>
<section>
	<form action="/Restaurant/Guest/Payment" method="post" style="display: none;" id="CompletePaymentForm">
		<input type="hidden" name="tableNumber" value="${tableNumber}">
		<input type="hidden" name="customersId" value="${mylogin.id}">
		<input type="hidden" name="customersName" value="${mylogin.name}">
	</form>
	<button onclick="completePayment()">전부결제</button>
</section>
</c:if>
<c:if test="${orderList eq null}">
	<h2>주문 내역이 없습니다!</h2>
</c:if>
</body>
</html>