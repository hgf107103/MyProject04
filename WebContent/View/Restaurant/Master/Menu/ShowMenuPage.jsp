<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마스터 : 메뉴보기</title>
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