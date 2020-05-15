<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마스터 : 메뉴 추가</title>
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
	}
	body {
		width: 500px;
	}
	*{
		text-align: center;
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
		box-shadow: 0 0 0 5px rgba(180, 180, 180, 0.3);
		transition: all ease 0.5s 0s;
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
		box-shadow: 0 0 0 5px rgba(180, 180, 180, 0.3);
		transition: all ease 0.5s 0s;
	}
	input[type=button] {
		cursor: pointer;
		border: 1px solid black;
		background-color: white;
		width: 150px;
		font-size: 25px;
		margin: 11px 0px;
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
	span.addSpan {
		font-family: "Gamja Flower";
		font-size: 25px;
		font-weight: bold;
	}
	#fieldOne {
		padding: 30px 0px;
	}
	#fieldOne label {
		color: rgb(200,200,200);
		transition: all ease 2s 0s;
	}
	#fieldOne label:hover {
		color: rgb(0,0,0);
		transition: all ease 0.5s 0s;
	}
	input[type=radio] {
		cursor: pointer;
		display: none;
	}
	#fieldTwo label {
		font-family: "Gamja Flower";
		font-size: 25px;
		cursor: pointer;
		font-weight: bold;
		padding: 0px 10px;
		color: rgb(250,250,250);
		transition: all ease 2s 0s;
	}
	#fieldTwo label:hover {
		color: rgb(0,0,0);
		transition: all ease 0.5s 0s;
	}
	#fieldTwo input:checked + span.categoryText {
		color: red;
		transition: all ease 0.5s 0s;
	}
	
	
</style>
</head>
<body>
<script type="text/javascript" src="/View/Restaurant/Master/Menu/JS/MenuAddControllScript.js"></script>

<form action="/Restaurant/Master/Menu/AddMenu" method="post" name="AddMenuForm">
	<fieldset id="fieldOne">
		<legend id="legendOne">메뉴 추가</legend>
		<label><span class="addSpan">메뉴 이름</span><br><input type="text" name="menuName" id="menuName" autocomplete="off" placeholder="메뉴 이름"></label><br>
		<label><span class="addSpan">메뉴 가격</span><br><input type="number" min="0" max="500000" step="100" name="menuCost" id="menuCost" placeholder="메뉴 가격"></label><br>
		<br>
		<fieldset id="fieldTwo">
			<legend id="legendTwo">메뉴 카테고리</legend>
			<label for="categoryOne"><input type="radio" id="categoryOne" class="category" name="category" value="전채요리" checked="checked"><span class="categoryText">전채요리</span></label>
			<label for="categoryTwo"><input type="radio" id="categoryTwo" class="category" name="category" value="육류"><span class="categoryText">육류</span></label>
			<label for="categoryThr"><input type="radio" id="categoryThr" class="category" name="category" value="해산물"><span class="categoryText">해산물</span></label>
			<br>
			<label for="categoryFou"><input type="radio" id="categoryFou" class="category" name="category" value="식사류"><span class="categoryText">식사류</span></label>
			<label for="categoryFiv"><input type="radio" id="categoryFiv" class="category" name="category" value="디저트"><span class="categoryText">디저트</span></label>
			<label for="categorySix"><input type="radio" id="categorySix" class="category" name="category" value="음료"><span class="categoryText">음료</span></label>
		</fieldset>
		<br>
		<input type="button" name="menuButton" onclick="AddMenu()" id="menuButton" value="추가">
		<input type="reset" value="리셋">
	</fieldset>
</form>

</body>
</html>