<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마스터 : 유저 명단</title>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gamja+Flower&display=swap" rel="stylesheet">
<style type="text/css">
	body {
		width: 600px;
	}
	h1 {
		text-align: center;
		width: 250px;
		cursor: default;
		margin: 20px auto;
		font-weight: normal;
		font-size: 40px;
		font-family: "Black Han Sans";
		transition: all ease 1s 0s;
	}
	h1:hover {
		color: rgb(50, 200, 150);
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
		text-overflow: ellipsis;
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
	table tr:hover > td.userNumberTd {
		color: rgb(40,168,40);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.userIdTd {
		color: rgb(255,100,100);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.userPassTd {
		color: rgb(100, 100, 255);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.userNameTd {
		color: rgb(168,40,168);
		transition: all ease 0.5s 0s;
	}
	table tr:hover > td.userSexTd {
		color: rgb(100,150,200);
		transition: all ease 0.5s 0s;
	}
	td a.updateUser {
		text-overflow: ellipsis;
		cursor: pointer;
		font-family: "Gamja Flower";
		font-weight: bold;
		font-size: 20px;
		background: none;
		border: none;
		color: black;
		text-decoration: none;
		transition: all ease 1s 0s;
	}
	table tr:hover > td a.updateUser {
		color: red;
		transition: all ease 0.5s 0s;
	}
	td a.updateUser:hover {
		font-size: 23px;
		transition: all ease 0.5s 0s;
	}
	td a.updateUser:visited {
		text-decoration: none;
	}
	div {
		margin-top: 150px;
		text-align: center;
	}
	div h2{
		cursor:default;
		font-size: 35px;
		font-family: "Gamja Flower";
		transition: all ease 1s 0s;
	}
	div h2:hover {
		color: red;
		transition: all ease 0.5s 0s;
	}
</style>
</head>
<body>
<h1>전체 회원 정보</h1>
<c:if test="${not empty userList}">
<table>
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>성별</th>
		<th>수정</th>
	</tr>
	<c:forEach items="${userList}" var="user" varStatus="status">
		<c:if test="${user.id ne 'admin' }">
			<tr>
    			<td class="userNumberTd">
    				<c:out value="${status.index}"></c:out>
    			</td>
    					
    			<td class="userIdTd">
    				<c:out value="${user.id}"></c:out>
    			</td>
    					
    			<td class="userPassTd">
    				<c:out value="${user.pwd}"></c:out>
    			</td>
    					
    			<td class="userNameTd">
    				<c:out value="${user.name}님"></c:out>
    			</td>
    		
    			<td class="userSexTd">
    				<c:out value="${user.sex}"></c:out>
    			</td>
    					
    			<td class="userUpdateTd">	
    				<a class="updateUser" href="#">정보수정</a>
    			</td>
			</tr>
		</c:if>
	</c:forEach>
</table>
</c:if>
	<c:if test="${userList eq null}">
		<div>
			<h2>회원 내역이 없습니다!</h2>
		</div>
	</c:if>

</body>
</html>