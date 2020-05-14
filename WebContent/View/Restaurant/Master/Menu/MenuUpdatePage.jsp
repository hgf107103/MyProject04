<%@ page import="Model.UserModel.UserVO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	UserVO uv = (UserVO)session.getAttribute("mylogin");
	if(!uv.getId().equals("admin")) {
		response.sendRedirect("/");
	}
%>
<title>마스터 : 메뉴수정</title>
<style type="text/css">
	legend {
		text-align: center;
	}
	body {
		width: 575px;
	}
	input{
		text-align: center;
	}
	*{
		text-align: center;
	}
	input[type=button] {
		cursor: pointer;
	}
	button {
		cursor: pointer;
	}
</style>
<script type="text/javascript" src="/View/Restaurant/Master/Menu/JS/MenuUpdateControllScript.js"></script>
</head>
<body>
<button onclick="history.go(-1)">뒤로</button>
<h1>메뉴수정</h1>
<form action="/Restaurant/Master/Menu/UpdateMenu" method="post" name="UpdateMenuForm">
	<fieldset>
		<legend>메뉴 추가</legend>
		<label>메뉴 번호<br>
			<input type="text" name="menuNumber" value="${updateMenu.menuNumber}" size="3" readonly="readonly" style="color: white; background-color: gray; border: none;"></label>
		<br>
		<br>
		
		<label>메뉴 이름<br>
			<input type="text" name="menuName" id="menuName" value="${updateMenu.menuName}" autocomplete="off" placeholder="메뉴 이름"></label><br>
		
		<label>메뉴 가격<br>
			<input type="number" min="0" max="500000" step="100" value="${updateMenu.menuCost}" name="menuCost" id="menuCost" placeholder="메뉴 가격">원</label><br>
		<br>
		<fieldset>
			<legend>메뉴 카테고리</legend>
			<c:choose>
    			<c:when test="${updateMenu.categoryName eq '전채요리'}">
    				<label>전채요리<input type="radio" class="category" name="category" value="전채요리" checked="checked"></label>
					<label>　　육류<input type="radio" class="category" name="category" value="육류"></label>
					<label>　해산물<input type="radio" class="category" name="category" value="해산물"></label>
					<br>
					<label>　식사류<input type="radio" class="category" name="category" value="식사류"></label>
					<label>　디저트<input type="radio" class="category" name="category" value="디저트"></label>
					<label>　　음료<input type="radio" class="category" name="category" value="음료"></label>
    			</c:when>
    			<c:when test="${updateMenu.categoryName eq '육류'}">
    				<label>전채요리<input type="radio" class="category" name="category" value="전채요리"></label>
					<label>　　육류<input type="radio" class="category" name="category" value="육류" checked="checked"></label>
					<label>　해산물<input type="radio" class="category" name="category" value="해산물"></label>
					<br>
					<label>　식사류<input type="radio" class="category" name="category" value="식사류"></label>
					<label>　디저트<input type="radio" class="category" name="category" value="디저트"></label>
					<label>　　음료<input type="radio" class="category" name="category" value="음료"></label>
    			</c:when>
    			<c:when test="${updateMenu.categoryName eq '해산물'}">
    				<label>전채요리<input type="radio" class="category" name="category" value="전채요리"></label>
					<label>　　육류<input type="radio" class="category" name="category" value="육류"></label>
					<label>　해산물<input type="radio" class="category" name="category" value="해산물" checked="checked"></label>
					<br>
					<label>　식사류<input type="radio" class="category" name="category" value="식사류"></label>
					<label>　디저트<input type="radio" class="category" name="category" value="디저트"></label>
					<label>　　음료<input type="radio" class="category" name="category" value="음료"></label>
    			</c:when>
    			<c:when test="${updateMenu.categoryName eq '식사류'}">
    				<label>전채요리<input type="radio" class="category" name="category" value="전채요리"></label>
					<label>　　육류<input type="radio" class="category" name="category" value="육류"></label>
					<label>　해산물<input type="radio" class="category" name="category" value="해산물"></label>
					<br>
					<label>　식사류<input type="radio" class="category" name="category" value="식사류" checked="checked"></label>
					<label>　디저트<input type="radio" class="category" name="category" value="디저트"></label>
					<label>　　음료<input type="radio" class="category" name="category" value="음료"></label>
    			</c:when>
    			<c:when test="${updateMenu.categoryName eq '디저트'}">
    				<label>전채요리<input type="radio" class="category" name="category" value="전채요리"></label>
					<label>　　육류<input type="radio" class="category" name="category" value="육류"></label>
					<label>　해산물<input type="radio" class="category" name="category" value="해산물"></label>
					<br>
					<label>　식사류<input type="radio" class="category" name="category" value="식사류"></label>
					<label>　디저트<input type="radio" class="category" name="category" value="디저트" checked="checked"></label>
					<label>　　음료<input type="radio" class="category" name="category" value="음료"></label>
    			</c:when>
    			<c:when test="${updateMenu.categoryName eq '음료'}">
    				<label>전채요리<input type="radio" class="category" name="category" value="전채요리"></label>
					<label>　　육류<input type="radio" class="category" name="category" value="육류"></label>
					<label>　해산물<input type="radio" class="category" name="category" value="해산물"></label>
					<br>
					<label>　식사류<input type="radio" class="category" name="category" value="식사류"></label>
					<label>　디저트<input type="radio" class="category" name="category" value="디저트"></label>
					<label>　　음료<input type="radio" class="category" name="category" value="음료" checked="checked"></label>
    			</c:when>
    			<c:otherwise>
    				<label>전채요리<input type="radio" class="category" name="category" value="전채요리"></label>
					<label>　　육류<input type="radio" class="category" name="category" value="육류"></label>
					<label>　해산물<input type="radio" class="category" name="category" value="해산물"></label>
					<br>
					<label>　식사류<input type="radio" class="category" name="category" value="식사류"></label>
					<label>　디저트<input type="radio" class="category" name="category" value="디저트"></label>
					<label>　　음료<input type="radio" class="category" name="category" value="음료"></label>
    			</c:otherwise>
    		</c:choose>
		</fieldset>
		<br>
		<input type="button" name="menuButton" onclick="UpdateMenu()" id="menuButton" value="수정">
	</fieldset>
</form>
</body>
</html>