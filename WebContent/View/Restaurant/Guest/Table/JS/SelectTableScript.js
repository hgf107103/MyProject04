function SelectDisableTable(tableNumber) {
	try {
		console.log("SelectDisableTable_LOG : select tableNumber Value is " + tableNumber);
		let form = document.getElementById("selectTableForm" + tableNumber);
		console.log("SelectDisableTable_LOG : select form id is " + tableNumber);
		
		let check = confirm(tableNumber + "번 테이블을 선택하셨습니다.\n맞습니까?");
		
		if (check) {
			console.log("SelectDisableTable_LOG : submit form");
			form.submit();
		} else {
			console.log("SelectDisableTable_LOG : cancle submit");
			return false;
		}
		
	} catch (e) {
		console.log("SelectDisableTable_ERROR : " + e);
		alert("오류가 발생했습니다.\n" + e);
		return false;
	}
}