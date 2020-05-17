<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마스터 : 테이블 보기</title>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gamja+Flower&display=swap" rel="stylesheet">
<style type="text/css">
	body{
		width: 650px;
		text-align: center;
	}
	form {
		display: inline-block;
		width: 180px;
		margin: auto;
	}
	input[type=button] {
		width: 50px;
		margin: 30px auto;
		padding: 10px 0px;
		text-align: center;
		font-size: 23px;
		border: 1px solid rgb(50, 200, 150);
		color: rgb(50, 200, 150);
		background-color: rgb(50, 200, 150);
		border-radius: 25px;
		font-family: "Gamja Flower";
		cursor: pointer;
		transition: all ease 1s 0s;
	}
	input[type=button]:hover {
		width: 150px;
		background-color: white;
		border: 1px solid rgb(50, 200, 150);
		box-shadow: 0 0 0 5px rgba(50, 200, 150, 0.2);
		transition: all ease 1s 0s;
	}
	input[type=button]:focus {
		outline: none;
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
	table tr:hover > td.noValue {
		color: rgb(220,220,220);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.tableNumberTd {
		color: rgb(40,168,40);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.customersIdTd {
		color: rgb(255,100,100);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.customersNameTd {
		color: rgb(100, 100, 255);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.costTotalTd {
		color: rgb(168,40,168);
		transition: all ease 0.5s 0s;
	}
	td a.showDetailLink {
		cursor: pointer;
		font-family: "Black Han Sans";
		font-weight: normal;
		font-size: 18px;
		background: none;
		border: none;
		color: black;
		text-decoration: none;
		transition: all ease 1s 0s;
	}
	td a.showDetailLink:hover {
		color: red;
		transition: all ease 0.5s 0s;
	}
	td a.showDetailLink:visited {
		text-decoration: none;
	}
	td a.noValue {
		cursor: pointer;
		font-family: "Black Han Sans";
		font-weight: normal;
		font-size: 18px;
		background: none;
		border: none;
		color: gray;
		text-decoration: none;
		transition: all ease 1s 0s;
	}
	table tr:hover > td a.noValue {
		color: rgb(220,220,220);
		transition: all ease 0.5s 0s;
	}
	td a.noValue:visited {
		text-decoration: none;
	}
</style>
<script type="text/javascript" src="/View/Restaurant/Master/Table/JS/TableAddControllScript.js"></script>
</head>
<body>
<form id="addTableForm" action="/Restaurant/Master/Table/AddTable" method="post">
	<input type="button" value="테이블 추가" onclick="AddTable()">
</form>
<form id="deleteTableForm" action="/Restaurant/Master/Table/DeleteTable" method="post">
	<input type="button" value="테이블 삭제" onclick="DeleteTable()">
</form>

<table>
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>이름</th>
		<th>계산 합계</th>
		<th>상세정보</th>
	</tr>
	<c:forEach items="${tableList}" var="table">
		<tr>
			
				<c:choose>
    				<c:when test="${table.customersId eq null}">
    					<td class="noValue"><c:out value="${table.tableNumber}"></c:out></td>
    					<td class="noValue">
    						빈 자리
    					</td>
    					<td class="noValue">
    						빈 자리
    					</td>
    					<td class="noValue"><c:out value="${table.costTotal}원"></c:out></td>
    					<td class="noValue">
    						<a class="noValue" href="#" onclick="alert('빈자리입니다.')">보기</a>
    					</td>
    				</c:when>
    				<c:otherwise>
    					
    					<td class="tableNumberTd">
    						<c:out value="${table.tableNumber}"></c:out>
    					</td>
    					
    					<td class="customersIdTd">
    						<c:out value="${table.customersId}"></c:out>
    					</td>
    					
    					<td class="customersNameTd">
    						<c:out value="${table.customersName}"></c:out>
    					</td>
    					
    					<td class="costTotalTd">
    						<c:out value="${table.costTotal}원"></c:out>
    					</td>
    					
    					<td class="showDetail">
    						<form action="/Restaurant/Master/Table/ShowTable/Detail" style="display: none;" method="post" id="TableDetailForm${table.tableNumber}">
    							<input type="hidden" name="tableNumber" value="${table.tableNumber}">
    							<input type="hidden" name="customersId" value="${table.customersId}">
    							<input type="hidden" name="customersName" value="${table.customersName}">
    							<input type="hidden" name="costTotal" value="${table.tableNumber}">
    						</form>
    						<a class="showDetailLink" href="#" onclick="showDetailTableOrder('${table.tableNumber}')">보기</a>
    					</td>
    					
    				</c:otherwise>
    			</c:choose>
		</tr>
	</c:forEach>
</table>
</body>
</html>