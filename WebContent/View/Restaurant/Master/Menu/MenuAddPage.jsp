<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마스터 : 메뉴 추가</title>
<style type="text/css">
	legend {
		text-align: center;
	}
	body {
		width: 350px;
	}
	*{
		text-align: center;
	}
</style>
</head>
<body>
<script type="text/javascript" src="/View/Restaurant/Master/Menu/JS/MenuAddControllScript.js"></script>

<form action="/Restaurant/Master/Menu/AddMenu" method="post" name="AddMenuForm">
	<fieldset>
		<legend>메뉴 추가</legend>
		<label>메뉴 이름<br><input type="text" name="menuName" id="menuName" autocomplete="off" placeholder="메뉴 이름"></label><br>
		<label>메뉴 가격<br><input type="number" min="0" max="500000" step="100" name="menuCost" id="menuCost" placeholder="메뉴 가격"></label><br>
		<br>
		<fieldset>
			<legend>메뉴 카테고리</legend>
			<label>전채요리<input type="radio" class="category" name="category" value="전채요리" checked="checked"></label>
			<label>　　육류<input type="radio" class="category" name="category" value="육류"></label>
			<label>　해산물<input type="radio" class="category" name="category" value="해산물"></label>
			<br>
			<label>　식사류<input type="radio" class="category" name="category" value="식사류"></label>
			<label>　디저트<input type="radio" class="category" name="category" value="디저트"></label>
			<label>　　음료<input type="radio" class="category" name="category" value="음료"></label>
		</fieldset>
		<br>
		<input type="button" name="menuButton" onclick="AddMenu()" id="menuButton" value="추가">
	</fieldset>
</form>

</body>
</html>