<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게스트 : ${categoryName}</title>
<script type="text/javascript">
	function menuDetailsSet() {
		let nameList = new Array();
		let costList = new Array();
		let nameList = new Array();
		
		<c:forEach items="${menuList}" var="menu">
			list.push("${menu.menuName}");
		</c:forEach>
		
		for (var i = 0; i < list.length; i++) {
			console.log("이름 : " + list[i]);
		}
		
	}
</script>
</head>
<body>

<input type="button" value="뒤로가기" onclick="history.go(-1)">
<h1>${categoryName}메뉴 보기</h1>
<select id="menuSelect" onchange="menuDetailsSet()">
<c:forEach items="${menuList}" var="menu">
	<option>${menu.menuName}</option>
</c:forEach>
</select>
<br>
<input type="text" id="menuNameText" readonly="readonly" value="${menuList[0].menuName}">
<input type="text" id="menuCostText" readonly="readonly" value="${menuList[0].menuCost}">
</body>
</html>