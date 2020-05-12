<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마스터 : 메뉴보기</title>
<style type="text/css">
	body{
		width: 500px;
	}
	table {
		width: 100%;
		
		border-collapse: collapse;
	}
	
	table th {
		text-align: center;
		background-color: black;
		color: white;
		padding: 10px;
		font-size: 18px;
		border-right: 1px solid black;
		border-left: 1px solid black;
	}
	
	table td {
		text-align: center;
		padding: 10px;
		border-bottom: 1px solid black;
		border-collapse: collapse;
	}
</style>
</head>
<body>
<h1>메뉴 전체보기</h1>
<hr>
<table>
	<tr>
		<th>번호</th>
		<th>카테고리</th>
		<th>이름</th>
		<th>가격</th>
	</tr>
	<c:forEach items="${menuList}" var="menu">
	<tr>
		<td><c:out value="${menu.menuNumber}"></c:out></td>
		<td><c:out value="${menu.categoryName}"></c:out></td>
		<td><c:out value="${menu.menuName}"></c:out></td>
		<td><c:out value="${menu.menuCost}원"></c:out></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>