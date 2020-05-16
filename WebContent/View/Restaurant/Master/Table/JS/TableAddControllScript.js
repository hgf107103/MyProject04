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

function DeleteTable() {
try {
		
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
		
	} catch (e) {
		console.log("AddTable_ERROR : " + e);
		alert("오류가 발생했습니다.\n" + e);
		return false;
	}
}