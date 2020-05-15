<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마스터 : 메뉴보기</title>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gamja+Flower&display=swap" rel="stylesheet">
<style type="text/css">
	body{
		width: 560px;
	}
	h1 {
		width: 320px;
		margin: 30px auto;
		margin-bottom: 5px;
		text-align: center;
		font-size: 45px;
		font-weight: normal;
		font-family: "Black Han Sans";
		cursor: default;
		transition: all ease 1s 0s;
	}
	h1:hover {
		color: rgb(20, 170, 120);
		font-size: 60px;
		text-shadow: 6px -6px 2px rgba(20, 170, 120, 0.3);
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
	table tr:hover > td.menuNumberTd {
		color: rgb(40,168,40);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.categoryNameTd {
		color: rgb(255,100,100);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.menuNameTd {
		color: rgb(100, 100, 255);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.menuCostTd {
		color: rgb(168,40,168);
		transition: all ease 0.5s 0s;
	}
	form {
		width: 80%;
		margin: 15px auto;
		margin-top: 0px;
		text-align: center;
	}
	
	form label {
		font-size: 17px;
	}
	td a {
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
	td a:hover {
		color: red;
		transition: all ease 0.5s 0s;
	}
	td a:visited {
		text-decoration: none;
	}
	td span {
		font-family: "Black Han Sans";
		color: black;
	}
	select {
		border-radius: 25px;
		width: 20px;
		padding: 5px;
		cursor: pointer;
		text-align: right;
		font-family: "Gamja Flower";
		font-size: 23px;
		font-weight: bold;
		border: 1px solid black;
		background-color: white;
		color: black;
		transition: all ease 0.5s 0s;
		margin: 10px 10px;
	}
	select:hover {
		width: 40%;
		border-radius: 0px;
		transition: all ease 0.5s 0s;
	}
	select:focus {
		width: 40%;
		outline: none;
		border-radius: 25px;
		border: 1px solid rgb(50,200,150);
		box-shadow: 0 0 0 5px rgba(50, 200, 150, 0.2);
		transition: all ease 0.5s 0s;
	}
	option {
		font-family: "Gamja Flower";
		font-size: 20px;
		font-weight: bold;
		background-color: white;
		color: black;
		transition: all ease 0.5s 0s;
	}
	option:checked {
		color: red;
		transition: all ease 0.5s 0s;
	}
</style>
</head>
<body>
<script type="text/javascript" src="/View/Restaurant/Master/Menu/JS/MenuDeleteControllScript.js"></script>

<h1>메뉴 전체보기</h1>
<form action="/Restaurant/Master/Menu/ShowMenu" method="post">
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
		<td class="menuNumberTd"><c:out value="${menu.menuNumber}"></c:out></td>
		<td class="categoryNameTd"><c:out value="${menu.categoryName}"></c:out></td>
		<td class="menuNameTd"><c:out value="${menu.menuName}"></c:out></td>
		<td class="menuCostTd"><c:out value="${menu.menuCost}원"></c:out></td>
		<td>
			<form action="/Restaurant/Master/Menu/DeleteMenu" style="display: none;" method="post" id="menuDeleteForm${menu.menuNumber}" name="menuDeleteForm">
				<input type="hidden" value="${menu.menuNumber}" name="menuNumber">
				<input type="hidden" value="${menu.menuName}" name="menuName">
				<input type="hidden" value="${menu.menuCost}" name="menuCost">
				<input type="hidden" value="${menu.categoryNumber}" name="categoryNumber">
				<input type="hidden" value="${menu.categoryName}" name="categoryName">
			</form>
			<a href="/Restaurant/Master/Menu/UpdateMenu?updateMenuName=${menu.menuName}">수정</a><span> / </span>
			<a href="#" onclick="deleteCheck(${menu.menuNumber}, '${menu.menuName}', ${menu.menuCost}, '${menu.categoryName}', ${menu.categoryNumber})">삭제</a>
		</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>