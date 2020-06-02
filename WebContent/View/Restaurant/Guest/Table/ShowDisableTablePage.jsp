<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게스트 : 테이블 선택</title>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gamja+Flower&display=swap" rel="stylesheet">
<style type="text/css">
	*:focus {
		outline: none;
	}
	body {
		width: 535px;
		text-align: center;
	}
	h1 {
		text-align: center;
		font-family: "Black Han Sans";
		font-size: 40px;
		font-weight: normal;
		cursor: default;
		margin-bottom: 10px;
	}
	table{
		margin: auto;
	}
	button {
		width: 180px;
		height: 180px;
		margin: 10px 10px;
	}
	
	button.disableTable {
		font-family: "Gamja Flower";
		border: 1px solid black;
		background-color: white;
		font-size: 30px;
		cursor: pointer;
		transition: all ease 1.5s 0s;
	}
	button > span{
		font-weight: bold;
	}
	button.disableTable:hover {
		border: 1px solid rgb(50, 200, 150);
		color: rgb(20, 170, 120);
		box-shadow: 0 0 0 5px rgba(50, 200, 150, 0.2);
		transition: all ease 0.5s 0s;
	}
	button.disableTable:focus {
		outline:none;
	}
	
	button.EnableTable {
		font-family: "Gamja Flower";
		border: 1px solid rgb(20,20,20);
		background-color: rgb(100,100,100);
		color: white;
		font-size: 25px;
		cursor: wait;
		transition: all ease 1.5s 0s;
	}
	button.EnableTable:hover {
		color: rgb(100,100,100);
		transition: all ease 0.5s 0s;
	}
	
	div {
		text-align: center;
		margin-top: 5px;
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
</style>
<script type="text/javascript" src="/View/Restaurant/Guest/Table/JS/SelectTableScript.js"></script>
</head>
<body>
<h1>테이블 선택</h1>
<table>
<c:forEach items="${tableList}" var="table" varStatus="status" begin="${((param.pageNumber - 1) * 4)}" end="${((param.pageNumber - 1) * 4) + 3}">
	<c:if test="${status.count % 2 == 1}">
		<tr>
	</c:if>
	<c:if test="${table.customersId eq null}">
		<td>
			<form action="/Restaurant/Guest/DisableTable" id="selectTableForm${table.tableNumber}" method="post" style="display: none;">
				<input type="hidden" name="selectTableNumber" value="${table.tableNumber}">
			</form>
			<button class="disableTable" onclick="SelectDisableTable('${table.tableNumber}')">
				<span>${table.tableNumber}번 테이블</span><br>
				비어있음
			</button>
		</td>
	</c:if>
	
	<c:if test="${table.customersId ne null}">
		<td>
			<button class="EnableTable" disabled="disabled" onclick="alert('누군가 사용중인 테이블은 선택 할 수 없습니다.')">
				<span>${table.tableNumber}번 테이블</span><br>
				${table.customersName}님<br>사용중
			</button>
		</td>
	</c:if>
	<c:if test="${status.count == 2}">
		</tr>
	</c:if>
</c:forEach>
</table>

	<c:if test="${param.pageNumber > (fn:length(tableList) / 5)+(1-((fn:length(tableList) / 5)%1))%1}">
		<script type="text/javascript">
			alert('마지막 페이지로 이동됩니다.');
			location.href = '/Restaurant/Guest/DisableTable?pageNumber=' + ${(fn:length(tableList) / 5)+(1-((fn:length(tableList) / 5)%1))%1};
		</script>
	</c:if>
	<c:if test="${param.pageNumber < 1}">
		<script type="text/javascript">
			alert('첫 페이지로 이동됩니다.');
			location.href = '/Restaurant/Guest/DisableTable?pageNumber=1';
		</script>
	</c:if>
<div>
	<c:if test="${param.pageNumber > 1}">
		<a href="/Restaurant/Guest/DisableTable?pageNumber=${param.pageNumber - 1}">뒤로</a>
	</c:if>
	<c:if test="${param.pageNumber > 0}">
	<c:forEach var="num" begin="${param.pageNumber - ((param.pageNumber - 1) % 5)}" end="${(param.pageNumber - ((param.pageNumber - 1) % 5)) + 4}" varStatus="now">
		<c:if test="${num <= (fn:length(tableList) / 5)+(1-((fn:length(tableList) / 5)%1))%1}">
			
			
			<c:if test="${num == param.pageNumber}">
				<span style="color: red;">${num}</span>
			</c:if>
			
			<c:if test="${num != param.pageNumber}">
				<a href="/Restaurant/Guest/DisableTable?pageNumber=${num}">${num}</a>
			</c:if>
			
		</c:if>
	</c:forEach>
	</c:if>
	<c:if test="${param.pageNumber < (fn:length(tableList) / 5)+(1-((fn:length(tableList) / 5)%1))%1}">
				<a href="/Restaurant/Guest/DisableTable?pageNumber=${param.pageNumber + 1}">앞으로</a>
	</c:if>
</div>
</body>
</html>