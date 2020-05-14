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
		width: 560px;
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
		border-right: 1px solid white;
		border-left: 1px solid black;
	}
	
	table td {
		text-align: center;
		padding: 10px;
		border-bottom: 1px solid black;
		border-collapse: collapse;
	}
	form {
		margin: 15px;
		width: 80%;
	}
	
	form label {
		font-size: 17px;
	}
	
	form select{
		width: 40%;
		padding: 5px;
		cursor: pointer;
	}
	td a {
		cursor: pointer;
		font-size: 16px;
		background: none;
		border: none;
		color: black;
		text-decoration: none;
	}
	td a:hover {
		color: red;
	}
	td a:visited {
		text-decoration: none;
	}
</style>
</head>
<body>
<script type="text/javascript" src="/View/Restaurant/Master/Menu/JS/MenuDeleteControllScript.js"></script>

<h1>메뉴 전체보기</h1>
<hr>
<form action="/Restaurant/Master/Menu/ShowMenu" method="post">
	<label>정렬　
    	<select id="listSort" name="listSort" onchange="form.submit()">
    		<c:choose>
    		<c:when test="${selectName eq 'menuNumber'}">
    			<option value="menuNumber" selected="selected">메뉴번호</option>
    			<option value="categoryName">카테고리</option>
    			<option value="menuName">메뉴이름</option>
    			<option value="menuCost">메뉴가격</option>
    		</c:when>
    		<c:when test="${selectName eq 'categoryName'}">
    		    <option value="menuNumber">메뉴번호</option>
    			<option value="categoryName" selected="selected">카테고리</option>
    			<option value="menuName">메뉴이름</option>
    			<option value="menuCost">메뉴가격</option>
    		</c:when>
    		<c:when test="${selectName eq 'menuName'}">
    		    <option value="menuNumber">메뉴번호</option>
    			<option value="categoryName">카테고리</option>
    			<option value="menuName" selected="selected">메뉴이름</option>
    			<option value="menuCost">메뉴가격</option>
    		</c:when>
    		<c:when test="${selectName eq 'menuCost'}">
    		    <option value="menuNumber">메뉴번호</option>
    			<option value="categoryName">카테고리</option>
    			<option value="menuName">메뉴이름</option>
    			<option value="menuCost" selected="selected">메뉴가격</option>
    		</c:when>
    		<c:otherwise>
    			<option value="menuNumber">메뉴번호</option>
    			<option value="categoryName">카테고리</option>
    			<option value="menuName">메뉴이름</option>
    			<option value="menuCost">메뉴가격</option>
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
	</label>
</form>
<table>
	<tr>
		<th>번호</th>
		<th>카테고리</th>
		<th>이름</th>
		<th>가격</th>
		<th>처리</th>
	</tr>
	<c:forEach items="${menuList}" var="menu">
	<tr>
		<td><c:out value="${menu.menuNumber}"></c:out></td>
		<td><c:out value="${menu.categoryName}"></c:out></td>
		<td><c:out value="${menu.menuName}"></c:out></td>
		<td><c:out value="${menu.menuCost}원"></c:out></td>
		<td>
			<form action="/Restaurant/Master/Menu/DeleteMenu" style="display: none;" method="post" id="menuDeleteForm${menu.menuNumber}" name="menuDeleteForm">
				<input type="hidden" value="${menu.menuNumber}" name="menuNumber">
				<input type="hidden" value="${menu.menuName}" name="menuName">
				<input type="hidden" value="${menu.menuCost}" name="menuCost">
				<input type="hidden" value="${menu.categoryNumber}" name="categoryNumber">
				<input type="hidden" value="${menu.categoryName}" name="categoryName">
			</form>
			<a href="/Restaurant/Master/Menu/UpdateMenu?updateMenuName=${menu.menuName}">수정</a> | 
			<a href="#" onclick="deleteCheck(${menu.menuNumber}, '${menu.menuName}', ${menu.menuCost}, '${menu.categoryName}', ${menu.categoryNumber})">삭제</a>
		</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>