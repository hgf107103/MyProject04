<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마스터 : 결제 내역</title>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gamja+Flower&display=swap" rel="stylesheet">
<style type="text/css">
	body {
		width: 700px;
	}
	h1 {
		text-align: center;
		width: 250px;
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
	table tr:hover > td.payDateTd {
		color: rgb(40,168,40);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.payNumberTd {
		color: rgb(255,100,100);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.tableNumberTd {
		color: rgb(100, 100, 255);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.customersNameTd {
		color: rgb(168,40,168);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.payTotalTd {
		color: rgb(100,150,200);
		transition: all ease 0.5s 0s;
	}
	td a.updatePay {
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
	table tr:hover > td a.updatePay {
		color: red;
		transition: all ease 0.5s 0s;
	}
	td a.updatePay:hover {
		font-size: 23px;
		transition: all ease 0.5s 0s;
	}
	td a.updatePay:visited {
		text-decoration: none;
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
<h1>가게 결제 내역</h1>
<c:if test="${not empty paymentList}">
<table>
	<tr>
		<th>날짜</th>
		<th>주문번호</th>
		<th>테이블</th>
		<th>이름</th>
		<th>합계</th>
		<th>상세보기</th>
	</tr>
	<c:forEach items="${paymentList}" var="pay" varStatus="status">
			<tr>
    			<td class="payDateTd">
    				<c:out value="${pay.payDate}"></c:out>
    			</td>
    					
    			<td class="payNumberTd">
    				<c:out value="${pay.payNumber}"></c:out>
    			</td>
    					
    			<td class="tableNumberTd">
    				<c:out value="${pay.tableNumber}번"></c:out>
    			</td>
    					
    			<td class="customersNameTd">
    				<c:out value="${pay.customersName}님"></c:out>
    			</td>
    		
    			<td class="payTotalTd">
    				<c:out value="${pay.payTotal}원"></c:out>
    			</td>
    					
    			<td class="payUpdateTd">
    				<form action=""></form>
    				<a class="updatePay" href="#">정보수정</a>
    			</td>
			</tr>
	</c:forEach>
</table>
</c:if>
	<c:if test="${empty paymentList}">
		<div>
			<h2>결재 내역이 없습니다!</h2>
		</div>
	</c:if>
	
</body>
</html>