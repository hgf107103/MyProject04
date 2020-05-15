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
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gamja+Flower&display=swap" rel="stylesheet">
<style type="text/css">
	legend {
		text-align: center;
		width: 200px;
		padding: 10px 0px;
		font-family: "Black Han Sans";
		cursor: default;
		transition: all ease 0.5s 0s;
	}
	legend:hover {
		color: rgb(50, 200, 150);
		transition: all ease 0.5s 0s;
		
	}
	body {
		width: 550px;
	}
	input[type=text] {
		margin: 10px auto;
		margin-bottom: 30px;
		width: 230px;
		padding: 10px 0px;
		font-size: 16px;
		text-decoration: none;
		outline: none;
		border: 1px solid gray;
		transition: all ease 0.5s 0s;
	}
	input[type=text]:focus {
		text-decoration: none;
		border-radius: 25px;
		border: 1px solid rgb(50, 200, 150);
		box-shadow: 0 0 0 5px rgba(50, 200, 150, 0.2);
		transition: all ease 0.5s 0s;
	}
	input[type=text]:hover {
		text-decoration: none;
		border-radius: 25px;
		transition: all ease 0.5s 0s;
	}
	input[type=text]#menuNumber {
		width: 40px;
		color: white;
		background-color: gray;
		border: none;
		cursor: default;
		margin-bottom: 10px;
		text-decoration: none;
		border-radius: 0px;
		transition: all ease 1s 0s;
	}
	input[type=text]#menuNumber:focus {
		text-decoration: none;
		border-radius: 25px;
		background-color: red;
		box-shadow: 0 0 0 3px rgba(255, 0, 0, 0.4);
		transition: all ease 1s 0s;
	}
	input[type=text]#menuNumber:hover {
		text-decoration: none;
		border-radius: 25px;
		transition: all ease 1s 0s;
	}
	input[type=number] {
		margin: 10px auto;
		width: 230px;
		padding: 10px 0px;
		font-size: 16px;
		text-decoration: none;
		outline: none;
		border: 1px solid gray;
		transition: all ease 0.5s 0s;
	}
	input[type=number]:focus {
		text-decoration: none;
		border-radius: 25px;
		border: 1px solid rgb(50, 200, 150);
		box-shadow: 0 0 0 5px rgba(50, 200, 150, 0.2);
		transition: all ease 0.5s 0s;
	}
	input[type=number]:hover {
		text-decoration: none;
		border-radius: 25px;
		transition: all ease 0.5s 0s;
	}
	input[type=button] {
		cursor: pointer;
		border: 1px solid black;
		background-color: white;
		width: 150px;
		font-size: 25px;
		margin: 11px 0px;
		margin-right: 20px;
		padding: 8px 0px;
		padding-top: 10px;
		font-family: "Black Han Sans";
		transition: all ease 0.5s 0s;
	}
	input[type=button]:hover{
		color: white;
		background-color: black;
		border-radius: 25px;
		transition: all ease 0.5s 0s;
	}
	input[type=button]:focus {
		outline: none;
	}
	input[type=reset] {
	
		cursor: pointer;
		border: 1px solid black;
		background-color: white;
		width: 150px;
		font-size: 25px;
		margin: 10px 0px;
		margin-left: 20px;
		padding: 8px 0px;
		padding-top: 10px;
		font-family: "Black Han Sans";
		transition: all ease 0.5s 0s;
	}
	input[type=reset]:hover{
		color: white;
		background-color: black;
		border-radius: 25px;
		transition: all ease 0.5s 0s;
	}
	input[type=reset]:focus {
		outline: none;
	}
	*{
		text-align: center;
	}
	button {
		cursor: pointer;
	}
	legend#legendOne {
		font-size: 30px;
	}
	legend#legendTwo {
		font-size: 25px;
	}
	fieldset {
		border: 1px solid black;
	}
	fieldset#fieldTwo {
		margin: 10px auto;
		padding-top: 20px;
		padding-bottom: 38px;
		width: 70%;
		transition: all ease 0.5s 0s;
	}
	fieldset#fieldTwo:hover {
		border: 1px solid red;
		border-radius: 25px;
		transition: all ease 0.5s 0s;
	}
	input[type=radio] {
		display: none;
	}
	span.categoryText {
		font-family: "Gamja Flower";
		font-size: 25px;
		cursor: pointer;
		font-weight: bold;
		padding: 0px 10px;
		color: rgb(250,250,250);
		transition: all ease 2s 0s;
	}
	span.categoryText:hover {
		color: rgb(0,0,0);
		transition: all ease 0.5s 0s;
	}
	#fieldOne label {
		color: rgb(200,200,200);
		transition: all ease 2s 0s;
	}
	#fieldOne .inputText {
		font-family: "Gamja Flower";
		font-size: 25px;
		font-weight: bold;
	}
	#fieldOne label:hover {
		color: rgb(0,0,0);
		transition: all ease 0.5s 0s;
	}
	#fieldOne #menuNumberText {
		color: rgb(200,200,200);
		transition: all ease 0.5s 0s;
	}
	#fieldOne #menuNumberText:hover {
		color: red;
		text-decoration: line-through;
		transition: all ease 0.5s 0s;
	}
	input[type=radio]:checked + span.categoryText {
		color: red;
		transition: all ease 0.5s 0s;
	}
	#backButton {
		font-family: "Gamja Flower";
		font-size: 23px;
		width: 50px;
		height: 50px;
		padding: 10px;
		margin: auto;
		background-color: black;
		color: black;
		border: 1px solid black;
		cursor: pointer;
		transition: all ease 0.5s 0s;
		border-radius: 25px;
	}
	#backButton:hover {
		border-radius: 0px;
		width: 150px;
		color: white;
		background-color: black;
		transition: all ease 0.5s 0s;
	}
	#backButton:focus {
		outline: none;
	}
</style>
<script type="text/javascript" src="/View/Restaurant/Master/Menu/JS/MenuUpdateControllScript.js"></script>
</head>
<body>
<input id="backButton" type="button" onclick="history.go(-1)"" value="뒤로">
<form action="/Restaurant/Master/Menu/UpdateMenu" method="post" name="UpdateMenuForm">
	<fieldset id="fieldOne">
		<legend id="legendOne">메뉴 수정</legend>
		<label id="menuNumberText"><span class="inputText">메뉴 번호</span><br>
			<input type="text" id="menuNumber" name="menuNumber" value="${updateMenu.menuNumber}" size="3" readonly="readonly"></label>
		<br>
		<br>
		
		<label><span class="inputText">메뉴 이름</span><br>
			<input type="text" name="menuName" id="menuName" value="${updateMenu.menuName}" autocomplete="off" placeholder="메뉴 이름"></label><br>
		
		<label><span class="inputText">메뉴 가격 (원)</span><br>
			<input type="number" min="0" max="500000" step="100" value="${updateMenu.menuCost}" name="menuCost" id="menuCost" placeholder="메뉴 가격"></label><br>
		<br>
		<fieldset id="fieldTwo">
			<legend id="legendTwo">메뉴 카테고리</legend>
			<c:choose>
    			<c:when test="${updateMenu.categoryName eq '전채요리'}">
    				<label><input type="radio" class="category" name="category" value="전채요리" checked="checked"><span class="categoryText">전채요리</span></label>
					<label><input type="radio" class="category" name="category" value="육류"><span class="categoryText">육류</span></label>
					<label><input type="radio" class="category" name="category" value="해산물"><span class="categoryText">해산물</span></label>
					<br>
					<label><input type="radio" class="category" name="category" value="식사류"><span class="categoryText">식사류</span></label>
					<label><input type="radio" class="category" name="category" value="디저트"><span class="categoryText">디저트</span></label>
					<label><input type="radio" class="category" name="category" value="음료"><span class="categoryText">음료</span></label>
    			</c:when>
    			<c:when test="${updateMenu.categoryName eq '육류'}">
    				<label><input type="radio" class="category" name="category" value="전채요리"><span class="categoryText">전채요리</span></label>
					<label><input type="radio" class="category" name="category" value="육류" checked="checked"><span class="categoryText">육류</span></label>
					<label><input type="radio" class="category" name="category" value="해산물"><span class="categoryText">해산물</span></label>
					<br>
					<label><input type="radio" class="category" name="category" value="식사류"><span class="categoryText">식사류</span></label>
					<label><input type="radio" class="category" name="category" value="디저트"><span class="categoryText">디저트</span></label>
					<label><input type="radio" class="category" name="category" value="음료"><span class="categoryText">음료</span></label>
    			</c:when>
    			<c:when test="${updateMenu.categoryName eq '해산물'}">
    				<label><input type="radio" class="category" name="category" value="전채요리"><span class="categoryText">전채요리</span></label>
					<label><input type="radio" class="category" name="category" value="육류"><span class="categoryText">육류</span></label>
					<label><input type="radio" class="category" name="category" value="해산물" checked="checked"><span class="categoryText">해산물</span></label>
					<br>
					<label><input type="radio" class="category" name="category" value="식사류"><span class="categoryText">식사류</span></label>
					<label><input type="radio" class="category" name="category" value="디저트"><span class="categoryText">디저트</span></label>
					<label><input type="radio" class="category" name="category" value="음료"><span class="categoryText">음료</span></label>
    			</c:when>
    			<c:when test="${updateMenu.categoryName eq '식사류'}">
    				<label><input type="radio" class="category" name="category" value="전채요리"><span class="categoryText">전채요리</span></label>
					<label><input type="radio" class="category" name="category" value="육류"><span class="categoryText">육류</span></label>
					<label><input type="radio" class="category" name="category" value="해산물"><span class="categoryText">해산물</span></label>
					<br>
					<label><input type="radio" class="category" name="category" value="식사류" checked="checked"><span class="categoryText">식사류</span></label>
					<label><input type="radio" class="category" name="category" value="디저트"><span class="categoryText">디저트</span></label>
					<label><input type="radio" class="category" name="category" value="음료"><span class="categoryText">음료</span></label>
    			</c:when>
    			<c:when test="${updateMenu.categoryName eq '디저트'}">
    				<label><input type="radio" class="category" name="category" value="전채요리"><span class="categoryText">전채요리</span></label>
					<label><input type="radio" class="category" name="category" value="육류"><span class="categoryText">육류</span></label>
					<label><input type="radio" class="category" name="category" value="해산물"><span class="categoryText">해산물</span></label>
					<br>
					<label><input type="radio" class="category" name="category" value="식사류"><span class="categoryText">식사류</span></label>
					<label><input type="radio" class="category" name="category" value="디저트" checked="checked"><span class="categoryText">디저트</span></label>
					<label><input type="radio" class="category" name="category" value="음료"><span class="categoryText">음료</span></label>
    			</c:when>
    			<c:when test="${updateMenu.categoryName eq '음료'}">
    				<label><input type="radio" class="category" name="category" value="전채요리"><span class="categoryText">전채요리</span></label>
					<label><input type="radio" class="category" name="category" value="육류"><span class="categoryText">육류</span></label>
					<label><input type="radio" class="category" name="category" value="해산물"><span class="categoryText">해산물</span></label>
					<br>
					<label><input type="radio" class="category" name="category" value="식사류"><span class="categoryText">식사류</span></label>
					<label><input type="radio" class="category" name="category" value="디저트"><span class="categoryText">디저트</span></label>
					<label><input type="radio" class="category" name="category" value="음료" checked="checked"><span class="categoryText">음료</span></label>
    			</c:when>
    			<c:otherwise>
    				<label><input type="radio" class="category" name="category" value="전채요리"><span class="categoryText">전채요리</span></label>
					<label><input type="radio" class="category" name="category" value="육류"><span class="categoryText">육류</span></label>
					<label><input type="radio" class="category" name="category" value="해산물"><span class="categoryText">해산물</span></label>
					<br>
					<label><input type="radio" class="category" name="category" value="식사류"><span class="categoryText">식사류</span></label>
					<label><input type="radio" class="category" name="category" value="디저트"><span class="categoryText">디저트</span></label>
					<label><input type="radio" class="category" name="category" value="음료"><span class="categoryText">음료</span></label>
    			</c:otherwise>
    		</c:choose>
		</fieldset>
		<br>
		<input type="button" name="menuButton" onclick="UpdateMenu()" id="menuButton" value="수정">
		<input type="reset" value="리셋">
	</fieldset>
</form>
</body>
</html>