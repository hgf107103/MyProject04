<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게스트 : 카테고리 선택</title>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gamja+Flower&display=swap" rel="stylesheet">
<style type="text/css">
	body {
		width: 535px;
		text-align: center;
		border-bottom: 1px solid black;
		padding-bottom: 10px;
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
	
	button.newOrderCategory {
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
	button.newOrderCategory:hover {
		border: 1px solid rgb(50, 200, 150);
		color: rgb(20, 170, 120);
		box-shadow: 0 0 0 5px rgba(50, 200, 150, 0.2);
		transition: all ease 0.5s 0s;
	}
	button:focus{
		outline: none;
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
<script type="text/javascript">
	function showMenuScript(number) {
		try {
			
			let form = document.getElementById("showMenuForm" + number);
			console.log("ShowMenuScript_LOG : Select CategoryName Value " + form.categoryName.value);
			
			if(form != null) {
				
				form.submit();
				
			} else {
				
				console.log("ShowMenuScript_NOT : Not Have Form");
				return false;
				
			}
			
		} catch (e) {
			console.log("ShowMenuScript_ERROR : " + e);
			return false;
		}
	}
</script>
</head>
<body>
<h1>카테고리 선택</h1>
<table>
<c:forEach items="${categoryList}" var="category" varStatus="status" begin="${((param.pageNumber - 1) * 4)}" end="${((param.pageNumber - 1) * 4) + 3}">
	<c:if test="${status.count % 2 == 1}">
		<tr>
	</c:if>
		<td>
			<form action="/Restaurant/Guest/Order" method="post" id="showMenuForm${status.count}">
				<input type="hidden" name="categoryName" value="${category}">
				<input type="hidden" name="tableNumber" value="${param.tableNumber}">
			</form>
			<button class="newOrderCategory" onclick="showMenuScript('${status.count}')">
				<span>${category}</span>
			</button>
		</td>
	<c:if test="${status.count == 2}">
		</tr>
	</c:if>
</c:forEach>
</table>
	<c:if test="${param.pageNumber > (fn:length(categoryList) / 5)+(1-((fn:length(categoryList) / 5)%1))%1}">
		<script type="text/javascript">
			alert('마지막 페이지로 이동됩니다.');
			location.href = '/Restaurant/Guest/Order?pageNumber=' + ${(fn:length(categoryList) / 5)+(1-((fn:length(categoryList) / 5)%1))%1} + '&tableNumber=$' + {param.tableNumber};
		</script>
	</c:if>
	<c:if test="${param.pageNumber < 1}">
		<script type="text/javascript">
			alert('첫 페이지로 이동됩니다.');
			location.href = '/Restaurant/Guest/Order?pageNumber=1&tableNumber=${param.tableNumber}';
		</script>
	</c:if>
<div>
	<c:if test="${param.pageNumber > 1}">
		<a href="/Restaurant/Guest/Order?pageNumber=${param.pageNumber - 1}&tableNumber=${param.tableNumber}">뒤로</a>
	</c:if>
	<c:if test="${param.pageNumber > 0}">
	<c:forEach var="num" begin="${param.pageNumber - ((param.pageNumber - 1) % 5)}" end="${(param.pageNumber - ((param.pageNumber - 1) % 5)) + 4}" varStatus="now">
		<c:if test="${num <= (fn:length(categoryList) / 5)+(1-((fn:length(categoryList) / 5)%1))%1}">
			
			
			<c:if test="${num == param.pageNumber}">
				<span style="color: red;">${num}</span>
			</c:if>
			
			<c:if test="${num != param.pageNumber}">
				<a href="/Restaurant/Guest/Order?pageNumber=${num}&tableNumber=${param.tableNumber}">${num}</a>
			</c:if>
			
		</c:if>
	</c:forEach>
	</c:if>
	<c:if test="${param.pageNumber < (fn:length(categoryList) / 5)+(1-((fn:length(categoryList) / 5)%1))%1}">
				<a href="/Restaurant/Guest/Order?pageNumber=${param.pageNumber + 1}&tableNumber=${param.tableNumber}">앞으로</a>
	</c:if>
</body>
</html>