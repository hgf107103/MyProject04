<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마스터 : 메뉴 추가</title>
</head>
<body>
<script type="text/javascript" src="/View/Restaurant/Master/Menu/JS/MenuAddControllScript.js"></script>

<form action="/Restaurant/Master/AddMenu" method="post" name="AddMenuForm">
	<fieldset>
		<legend>메뉴 추가</legend>
		<label>메뉴 이름 : <input type="text" name="menuName" id="menuName" autocomplete="off" placeholder="메뉴 이름"></label><br>
		<label>메뉴 가격 : <input type="number" min="0" max="500000" step="100" name="menuCost" id="menuCost" placeholder="메뉴 가격"></label><br>
		<input type="button" name="menuButton" onclick="AddMenu()" id="menuButton" value="추가">
	</fieldset>
</form>

</body>
</html>