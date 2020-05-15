<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="everyHeader" style="padding: 20px;">
<script type="text/javascript">
	function back() {
		try {
			console.log("Go History Back");
			history.go(-1);
			
		} catch (e) {
			console.log("ERROR : " + e);
			return false;
		}
	}
</script>
	<a href="/"><button id="headerButton" style="cursor: pointer;">Index</button></a>
	<br>
	<button id="backButton" onclick="back()">이전페이지로</button>
</div>
<hr>