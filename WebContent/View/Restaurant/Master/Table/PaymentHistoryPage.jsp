<%@ page import="java.util.Date" %>
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
		text-align: center;
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
		margin-top: 20px;
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
	select {
		border-radius: 0px;
		width: 30%;
		padding: 5px;
		cursor: pointer;
		text-align: center;
		font-family: "Gamja Flower";
		font-size: 23px;
		font-weight: bold;
		border: 1px solid black;
		background-color: white;
		color: black;
		transition: all ease 1s 0s;
		margin: 10px 10px;
	}
	select#listDay {
		width: 50%;
		transition: all ease 1s 0s;
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
	}
	option:checked {
		color: red;
	}
</style>
<script type="text/javascript" src="/View/Restaurant/Master/Table/JS/PaymentShowControllerScript.js"></script>
</head>
<body>
<h1>가게 결제 내역</h1>
<c:if test="${not empty paymentList}">
<form action="/Restaurant/Master/Table/ShowPayment" method="post">
    	<select id="listSort" name="listSort" onchange="form.submit()">
    		<c:choose>
    		<c:when test="${selectName eq 'payDate'}">
    			<option value="payDate" selected="selected">날짜</option>
    			<option value="t1.payNumber">결제번호</option>
    			<option value="tableNumber">테이블번호</option>
    			<option value="customersName">고객이름</option>
    			<option value="payTotal">합계</option>
    		</c:when>
    		<c:when test="${selectName eq 't1.payNumber'}">
    		    <option value="payDate">날짜</option>
    			<option value="t1.payNumber" selected="selected">결제번호</option>
    			<option value="tableNumber">테이블번호</option>
    			<option value="customersName">고객이름</option>
    			<option value="payTotal">합계</option>
    		</c:when>
    		<c:when test="${selectName eq 'tableNumber'}">
    		    <option value="payDate">날짜</option>
    			<option value="t1.payNumber">결제번호</option>
    			<option value="tableNumber" selected="selected">테이블번호</option>
    			<option value="customersName">고객이름</option>
    			<option value="payTotal">합계</option>
    		</c:when>
    		<c:when test="${selectName eq 'customersName'}">
    		    <option value="payDate">날짜</option>
    			<option value="t1.payNumber">결제번호</option>
    			<option value="tableNumber">테이블번호</option>
    			<option value="customersName" selected="selected">고객이름</option>
    			<option value="payTotal">합계</option>
    		</c:when>
    		<c:when test="${selectName eq 'payTotal'}">
    		    <option value="payDate">날짜</option>
    			<option value="t1.payNumber">결제번호</option>
    			<option value="tableNumber">테이블번호</option>
    			<option value="customersName">고객이름</option>
    			<option value="payTotal" selected="selected">합계</option>
    		</c:when>
    		<c:otherwise>
    			<option value="payDate">날짜</option>
    			<option value="t1.payNumber">결제번호</option>
    			<option value="tableNumber">테이블번호</option>
    			<option value="customersName">고객이름</option>
    			<option value="payTotal">합계</option>
    		</c:otherwise>
    		</c:choose>
		</select>
		<select id="listSortOrderBy" name="listSortOrderBy" onchange="form.submit()">
			<c:choose>
    			<c:when test="${selectSort eq 'ASC'}">
    				<option value="ASC" selected="selected">오름차순</option>
    				<option value="DESC">내림차순</option>
    			</c:when>
    			<c:when test="${selectSort eq 'DESC'}">
    				<option value="ASC">오름차순</option>
    				<option value="DESC" selected="selected">내림차순</option>
    			</c:when>
    			<c:otherwise>
    				<option value="ASC">오름차순</option>
    				<option value="DESC">내림차순</option>
    			</c:otherwise>
    		</c:choose>
		</select>
		<br>
		<select id="listDay" name="listDay" onchange="form.submit()">
    		<c:choose>
    		<c:when test="${selectDay eq 'dateAll'}">
    			<option value="dateAll" selected="selected">전체기간</option>
    			<option value="dateToday">오늘</option>
    			<option value="dateWeek">일주일 이내</option>
    			<option value="dateMonth">한달 이내</option>
    			<option value="dateYear">일년 이내</option>
    		</c:when>
    		<c:when test="${selectDay eq 'dateToday'}">
    		    <option value="dateAll">전체기간</option>
    			<option value="dateToday" selected="selected">오늘</option>
    			<option value="dateWeek">일주일 이내</option>
    			<option value="dateMonth">한달 이내</option>
    			<option value="dateYear">일년 이내</option>
    		</c:when>
    		<c:when test="${selectDay eq 'dateWeek'}">
    		    <option value="dateAll">전체기간</option>
    			<option value="dateToday">오늘</option>
    			<option value="dateWeek" selected="selected">일주일 이내</option>
    			<option value="dateMonth">한달 이내</option>
    			<option value="dateYear">일년 이내</option>
    		</c:when>
    		<c:when test="${selectDay eq 'dateMonth'}">
    		    <option value="dateAll">전체기간</option>
    			<option value="dateToday">오늘</option>
    			<option value="dateWeek">일주일 이내</option>
    			<option value="dateMonth" selected="selected">한달 이내</option>
    			<option value="dateYear">일년 이내</option>
    		</c:when>
    		<c:when test="${selectDay eq 'dateYear'}">
    		    <option value="dateAll">전체기간</option>
    			<option value="dateToday">오늘</option>
    			<option value="dateWeek">일주일 이내</option>
    			<option value="dateMonth">한달 이내</option>
    			<option value="dateYear" selected="selected">일년 이내</option>
    		</c:when>
    		<c:otherwise>
    			<option value="dateAll">전체기간</option>
    			<option value="dateToday">오늘</option>
    			<option value="dateWeek">일주일 이내</option>
    			<option value="dateMonth">한달 이내</option>
    			<option value="dateYear">일년 이내</option>
    		</c:otherwise>
    		</c:choose>
		</select>
		<!-- 위 셀렉트는 날자 기준을 더 잡는 -->
</form>
<table>
	<tr>
		<th>날짜</th>
		<th>결제번호</th>
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
    				<form action="/Restaurant/Master/Table/PaymentDetail" style="display: none;" method="get" id="detail${pay.payNumber}">
    					<input type="hidden" value="${pay.payDate}" name="payDate">
    					<input type="hidden" value="${pay.payNumber}" name="payNumber">
    					<input type="hidden" value="${pay.tableNumber}" name="tableNumber">
    					<input type="hidden" value="${pay.customersName}" name="customersName">
    					<input type="hidden" value="${pay.payTotal}" name="payTotal">
    				</form>
    				<a class="updatePay" href="#" onclick="paymentDetailShow('${pay.payNumber}')">상세보기</a>
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