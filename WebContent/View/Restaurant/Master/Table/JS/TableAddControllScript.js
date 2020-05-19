function AddTable() {
	
	try {
		
		let form = document.getElementById("addTableForm");
		let check = confirm("테이블을 추가하시겠습니까?");
		
		if (check) {
			console.log("AddTable_LOG : Submit AddTableForm");
			form.submit();
		} else {
			console.log("AddTable_LOG : Cancel Submit AddTableForm");
			alert("취소되었습니다.");
			return false;
		}
		
	} catch (e) {
		console.log("AddTable_ERROR : " + e);
		alert("오류가 발생했습니다.\n" + e);
		return false;
	}
	
}

function DeleteTable(listLength) {
try {
		if (Number(listLength) > 1) {
			let form = document.getElementById("deleteTableForm");
			let check = confirm("테이블을 삭제하시겠습니까?");
			
			if (check) {
				let checkTwo = confirm("마지막으로 묻습니다.\n정말로 삭제하시겠습니까?")
				if (checkTwo) {
					console.log("AddTable_LOG : Submit AddTableForm");
					form.submit();
				}	else {
					console.log("AddTable_LOG : Cancel Submit AddTableForm");
					alert("취소되었습니다.");
					return false;
				}
				
			} else {
				console.log("AddTable_LOG : Cancel Submit AddTableForm");
				alert("취소되었습니다.");
				return false;
			}
		} else {
			console.log("AddTable_LOG : Lack of listLength value");
			alert("테이블은 최소 하나 이상 있어야 합니다.");
			return false;
		}
	
		
		
	} catch (e) {
		console.log("AddTable_ERROR : " + e);
		alert("오류가 발생했습니다.\n" + e);
		return false;
	}
}

function showDetailTableOrder(tableNumber) {
	try {
		
		console.log("TableDetailForm" + tableNumber);
		
		let form = document.getElementById("TableDetailForm" + tableNumber);
		let check = confirm("테이블 상세내역을 확인하겠습니까?");
		
		
		if (check) {
			console.log("ShowDetailTableOrder_LOG : Submit AddTableForm");
			form.submit();
		} else {
			console.log("ShowDetailTableOrder_LOG : Cancel Submit AddTableForm");
			alert("취소되었습니다.");
			return false;
		}
		
	} catch (e) {
		console.log("ShowDetailTableOrder_ERROR : " + e);
		alert("오류가 발생했습니다.\n" + e);
		return false;
	}
}